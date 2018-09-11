package com.assisenior.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.assisenior.appli.Appli;
import com.assisenior.model.Contact;
import com.assisenior.service.ContactService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static String VIEW_PAGES_URL="/WEB-INF/login.jsp";

	String actionMessage;
	String display;
	String title;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		Appli.launchAppli();
		HttpSession session = request.getSession();		
		Appli.connected(session);			
		boolean connected = session.getAttribute("connected") != null;

		if(connected){
			session.invalidate();
			WelcomeServlet.loginMessage = "Connexion";
			response.sendRedirect("welcome");
		} else {		
			WelcomeServlet.loginMessage = "Connexion";
			request.setAttribute("loginMessage", WelcomeServlet.loginMessage);
			display = "none";
			request.setAttribute("display", display);
			title = "Connexion";
			request.setAttribute("title", title);		
			this.getServletContext().getRequestDispatcher(VIEW_PAGES_URL).forward( request, response );
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		Contact contact = ContactService.findByLogin(request.getParameter("login"), request.getParameter("password"));
		RequestDispatcher dispat;

		if (contact != null) {
			HttpSession session = request.getSession();
			Appli.addSessionConnected(session);
			session.setAttribute("login",request.getParameter("login"));
			session.setAttribute("password",request.getParameter("password"));
			session.setAttribute("connected", true);
			session.setAttribute("utilisateur", contact);

			WelcomeServlet.loginMessage = "Deconnexion";
			request.setAttribute("loginMessage", WelcomeServlet.loginMessage);

			dispat = request.getRequestDispatcher("WelcomeServlet");
			dispat.forward(request,response);
		
		} else {
			display = "display !important";
			request.setAttribute("display", display);
			WelcomeServlet.loginMessage = "Connexion";
			request.setAttribute("loginMessage", WelcomeServlet.loginMessage);
			actionMessage = "Login ou mot de passe incorrect";
			request.setAttribute("actionMessage", actionMessage);
			this.getServletContext().getRequestDispatcher(VIEW_PAGES_URL).forward( request, response );
		}
	}
}
