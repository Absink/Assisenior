package com.assisenior.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.assisenior.model.Contact;
import com.assisenior.service.AlertService;
import com.assisenior.service.AssistedPersonService;
import com.assisenior.service.ContactService;

/**
 * Servlet implementation class ContactServlet
 */
@WebServlet("/ContactServlet")
public class ContactServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	public static String VIEW_PAGES_URL="/WEB-INF/contact.jsp";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ContactServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		HttpSession session = request.getSession();
		boolean connected = session.getAttribute("connected") != null;
		AlertService.alerter(1, 2, 1);
		this.getServletContext().getRequestDispatcher(VIEW_PAGES_URL).forward( request, response );	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		
	}
}
