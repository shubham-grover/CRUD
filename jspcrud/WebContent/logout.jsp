<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@page import="com.crupapp.dao.UserDao"%>
    <%@page import="com.crudapp.bean.User"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Logout</title>
</head>
<body>
<jsp:useBean id="user" class="com.crudapp.bean.User"></jsp:useBean>  
<jsp:setProperty property="*" name="user"/>
<% session.invalidate();
   request.getRequestDispatcher("login.jsp").include(request, response); 
%>
<p align="center"><strong><u>You have been successfully logout</u></strong></p>
</body>
</html>