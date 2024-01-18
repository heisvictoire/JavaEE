package com.example.todolist;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Dashboard")
public class DashboardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Vérifier si l'utilisateur est connecté (vous pouvez utiliser une session pour
		// gérer cela)
		// Pour l'exemple, nous supposons simplement qu'ils sont connectés

		// Afficher le contenu du tableau de bord
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			out.println("<html><head><title>Dashboard</title></head><body>");
			out.println("<h1>Bienvenue sur le Tableau de Bord</h1>");
			out.println("<p>Contenu du tableau de bord...</p>");
			out.println("</body></html>");
		}
	}
}
