package com.assisenior.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.assisenior.service.DetectionChuteService;
import com.assisenior.service.HeartMonitoringService;

@WebServlet("/HeartMonitoring")
public class HeartMonitoringServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static String VIEW_PAGES_URL="/WEB-INF/heartMonitoring.jsp";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HeartMonitoringServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		HttpSession session = request.getSession();		
		System.out.println("Launch 'heartMonitoring' servlet");
		// requete http://localhost:8080/assisenior/heartMonitoring?beat=59
		int beat = Integer.parseInt(request.getParameter("beat"));
		HeartMonitoringService.controlHeartBeat(beat);
		
		
	}
}