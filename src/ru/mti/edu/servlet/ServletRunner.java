package ru.mti.edu.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.Principal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletRunner
 */
@WebServlet("/ServletRunner")
public class ServletRunner extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.authenticate(response);
		Principal principal = request.getUserPrincipal();
		// TODO Auto-generated method stub
		response.addCookie(new Cookie("test", "test"));
		try (PrintWriter pw = response.getWriter()) {
			pw.append("Get served at: ").append(request.getContextPath()).append(" authorized by ").append(principal.getName())
			.append((String) request.getServletContext().getAttribute("applicationScope"));
			HttpSession session = request.getSession(false);
			if (session == null){
				session = request.getSession();
			}
//			session.setAttribute(arg0, arg1);
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// TODO Auto-generated method stub
		response.addCookie(new Cookie("test", "test"));
		try (PrintWriter pw = response.getWriter()) {
			pw.append("Post served at: ").append(request.getContextPath());
		}
	}

}
