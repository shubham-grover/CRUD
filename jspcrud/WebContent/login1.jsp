<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.crupapp.dao.UserDao"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>login check</title>
</head>
<body>



<jsp:useBean id="user" class="com.crudapp.bean.User"></jsp:useBean>  
<jsp:setProperty property="*" name="user"/>  
<%
String E=request.getParameter("Email");  
String p=request.getParameter("password");  


int _id = UserDao.login(E,p);
if(_id != 0)
{   System.out.print("in login1.jsp,user_id is :"+_id);
    System.out.print("logged in successfully");
	request.getSession().setAttribute("id",_id);
	request.getRequestDispatcher("profile_page1.jsp").include(request, response);
}
else
{
	 out.print("Sorry, username,email or password error!");
	 request.getRequestDispatcher("login.jsp").include(request, response); 
}
%>
</body>
</html>