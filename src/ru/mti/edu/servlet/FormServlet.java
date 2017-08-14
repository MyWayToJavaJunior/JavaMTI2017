package ru.mti.edu.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

public class FormServlet extends HttpServlet {

	@Override
	public void init(ServletConfig config) throws ServletException {
		
	}
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		try(PrintWriter pw = response.getWriter()){
			pw.println("<!DOCTYPE html>");
			pw.println("<html>");
			pw.println("<head>");
			pw.println("<meta charset=\"UTF-8\">");
			pw.println("</head>");
			pw.println("<body>Здесь могла быть Ваша реклама!!");
			pw.println(getDbText(getConnection()));
			pw.println("</body>");
			pw.println("</html>");
		}
	}
	
	public static Connection getConnection() {
		InitialContext ic;
		try {
			ic = new InitialContext();
			DataSource dataSource = (DataSource) ic.lookup("java:comp/env/jdbc/MTIDS");
			return dataSource.getConnection();
		} catch (NamingException | SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String getDbText(Connection connection) {
		String result = null;
		try (Statement stat = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, 
					ResultSet.CONCUR_UPDATABLE)) {
			try (ResultSet rs = stat.executeQuery("select * from emp, dept " +
					"where emp.deptno = dept.deptno " +
					"order by emp.empno desc")) {
				while(rs.next()) {
					result += " " + rs.getString("loc");
				}
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public void destroy() {
		
	}
}
