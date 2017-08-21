<%@ page import="java.time.LocalDate"%>
<%@ page import="static java.math.BigDecimal.*"%>
<%@ page language="java" %>
<%! public static boolean checkDay(){
		return LocalDate.now().getDayOfMonth() % 2 == 0;
	}
%>