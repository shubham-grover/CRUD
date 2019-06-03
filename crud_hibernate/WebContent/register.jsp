<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="crud_hibernate.dao.UserDao"%>
     <%@page import="com.crud_hibernate.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>register page</title>
</head>
<body>
 
<%  

System.out.println("register.jsp called");
String name = (String)request.getSession().getAttribute("name");
System.out.println("register.jsp called name = "+name );
String email = (String)request.getSession().getAttribute("email");
System.out.println("register.jsp called email="+email);
String password = (String)request.getSession().getAttribute("password");
System.out.println("register.jsp called password="+password);
User user = new User();
user.setEmail(email);
System.out.println("setting email="+email);
user.setName(name);
System.out.println("setting name="+name);
user.setPassword(password);
System.out.println("setting password="+password);

int i=UserDao.register(user);  
if(i>0)  {
	out.print("i is="+i);
	out.print("You are successfully registered");  
}
else{
	out.print("i is="+i);
	out.print("sorry unable to register");
}
%> 
</body>
</html>