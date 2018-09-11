package com.assisenior.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.assisenior.appli.Appli;

/**
 * Servlet implementation class WelcomeServlet
 */

@WebServlet("/WelcomeServlet")
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static String VIEW_PAGES_URL="/index.jsp";

	String actionMessage;
	public static String loginMessage = "Connexion";
	public static boolean identified = true;
	String display;
	String title;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public WelcomeServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();

		if(!Appli.authentificatedSession(session)) {
			System.out.println("non authentifi�");
			this.getServletContext().getRequestDispatcher("/login").forward( request, response );
		} else {
			title = "Accueil";
			request.setAttribute("title", title);
			request.setAttribute("loginMessage", loginMessage);

			if(session.getAttribute("utilisateur") != null){		
				request.setAttribute("utilisateur", session.getAttribute("utilisateur"));
			}
			this.getServletContext().getRequestDispatcher(VIEW_PAGES_URL).forward( request, response );
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
