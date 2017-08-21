<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp" isELIgnored="false"%>
<%@taglib uri="/mti" prefix="my"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@include file="logic.jsp" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hello World</title>
</head>
<body>
	<% if (checkDay()) { %>
	   Четный день месяца
	   <% } else { %>
	   Четный день месяца
	  <% } %>
	  
	  <%= 5 / 2 %>
	  <% out.println( 5 / 2 ); 
	   %>
	   ${param.test}
	   
	   <my:now year="2017"></my:now>
</body>
</html>