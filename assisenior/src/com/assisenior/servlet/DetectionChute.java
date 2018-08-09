package com.assisenior.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.assisenior.service.DetectionChuteService;

@WebServlet("/DetectionChute")
public class DetectionChute extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static String VIEW_PAGES_URL="/WEB-INF/detectionChute.jsp";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DetectionChute() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		HttpSession session = request.getSession();		
		System.out.println("Launch 'detectionChute' servlet");
		// requette http://localhost:8080/assisenior/detection_chute?name=msgrecupere
		System.out.println("test: " + request.getParameter("name"));
		
		DetectionChuteService.dataChute(1,  2,  3);
		
		
	}
}