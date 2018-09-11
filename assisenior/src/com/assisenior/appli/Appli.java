package com.assisenior.appli;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

public class Appli extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static Set<HttpSession> sessions = Collections.synchronizedSet(new HashSet<HttpSession>());
	
	public static void launchAppli() {
		ThreadValues z = new ThreadValues();
		z.start();
	}

	public static void synchroActions (String message, HttpSession session) throws IOException {
		synchronized(sessions) {
			for(HttpSession client : sessions) {				
				if (!client.equals(session)) {
					System.out.println("synchronize all sessions");
					client.setAttribute("messages", message);
				}
			}
		}
	}

	public static boolean connected (HttpSession session) {
		Iterator anIterator=sessions.iterator();
		while (anIterator.hasNext()) {
			if (anIterator.next().equals(session)) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}
	
	public static void addSessionConnected (HttpSession session) {	
		sessions.add(session);
	}
	
	public static boolean authentificatedSession (HttpSession session) {
		Iterator anIterator=sessions.iterator();
		while (anIterator.hasNext()) {
			if (anIterator.next().equals(session)) {
				return true;
			}
		}
		return false;
	}
}