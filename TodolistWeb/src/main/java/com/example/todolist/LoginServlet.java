
package com.example.todolist;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Configuration de la connexion à la base de données
    private static final String JDBC_URL = "jdbc:mysql://localhost:3307/todolist";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "";

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try {
            // Charger le pilote JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Établissement de la connexion à la base de données
            try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
                // Préparation de la requête de vérification des informations de connexion
                String query = "SELECT * FROM utilisateur WHERE email = ? AND password = ?";
                try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                    preparedStatement.setString(1, email);
                    preparedStatement.setString(2, password);

                    // Exécution de la requête
                    try (ResultSet resultSet = preparedStatement.executeQuery()) {
                        if (resultSet.next()) {
                            // Connexion réussie
                            response.sendRedirect("Dashboard.jsp");
                        } else {
                            // Informations de connexion incorrectes
                            showErrorPage(response, "Échec de la connexion. Veuillez vérifier vos informations.");
                        }
                    }
                }
            }

        } catch (ClassNotFoundException | SQLException e) {
            // Gestion des exceptions liées à la base de données
            e.printStackTrace();
            showErrorPage(response, "Erreur de connexion à la base de données. Veuillez réessayer.");
        }
    }

    private void showErrorPage(HttpServletResponse response, String errorMessage) throws IOException {
        PrintWriter out = response.getWriter();
        out.println("<html><body><p>" + errorMessage + "</p></body></html>");
    }
}
