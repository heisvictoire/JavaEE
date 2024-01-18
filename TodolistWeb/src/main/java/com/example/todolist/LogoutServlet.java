package com.example.todolist;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Logout")
public class LogoutServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processLogout(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processLogout(request, response);
	}

	private void processLogout(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);

		if (session != null) {
			// Supprime l'objet utilisateur de la session (ajustez selon votre structure de
			// session)
			session.removeAttribute("user");

			// Invalide la session
			session.invalidate();
		}

		// Redirige vers la page de connexion (ajustez selon votre structure d'URL)
		response.sendRedirect(request.getContextPath() + "/Login.jsp");
	}
}
