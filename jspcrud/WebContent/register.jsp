<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.crupapp.dao.UserDao"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>registration page</title>
</head>
<body>
 
<jsp:useBean id="u" class="com.crudapp.bean.User"></jsp:useBean>  
<jsp:setProperty property="*" name="u"/>  
  
<%  
int status=UserDao.save(u);  
if(status>0){  
	System.out.println("registration successful");
response.sendRedirect("login.jsp");  
}else{  
	System.out.println("sorry! unable to register,please try again...");%>

     <script>
	 alert("sorry! unable to register,please try again...");		
	 </script>
<% response.sendRedirect("adduserform.jsp");  
}  
%>  

</body>
</html>