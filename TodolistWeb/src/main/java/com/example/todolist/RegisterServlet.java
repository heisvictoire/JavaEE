package com.example.todolist;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Configuration de la connexion à la base de données
	private static final String JDBC_URL = "jdbc:mysql://localhost:3307/todolist";
	private static final String JDBC_USER = "root";
	private static final String JDBC_PASSWORD = "";

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String fullname = request.getParameter("fullname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		try {
			// Charger le pilote JDBC
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Établissement de la connexion à la base de données
			try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
				// Préparation de la requête d'insertion
				String query = "INSERT INTO utilisateur (fullname, email, password) VALUES (?, ?, ?)";
				try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
					preparedStatement.setString(1, fullname);
					preparedStatement.setString(2, email);
					preparedStatement.setString(3, password);

					// Exécution de la requête
					int rowsAffected = preparedStatement.executeUpdate();

					if (rowsAffected > 0) {
						// Inscription réussie
						response.sendRedirect("Login.jsp");
					} else {
						// Inscription échouée
						PrintWriter out = response.getWriter();
						out.println("<html><body><p>Échec de l'inscription. Veuillez réessayer.</p></body></html>");
					}
				}
			}

		} catch (ClassNotFoundException | SQLException e) {
			// Gestion des exceptions liées à la base de données
			e.printStackTrace();
			PrintWriter out = response.getWriter();
			out.println(
					"<html><body><p>Erreur de connexion à la base de données. Veuillez réessayer.</p></body></html>");
		}
	}
}
