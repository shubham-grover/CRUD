<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="com.crupapp.dao.UserDao"%>
    <%@page import="com.crudapp.bean.User"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="user" class="com.crudapp.bean.User"></jsp:useBean>  
<jsp:setProperty property="*" name="user"/>
<%
int _id=(int)request.getSession().getAttribute("id");
System.out.println("id in Delete_info.jsp="+_id);
int status=UserDao.delete_info(_id);
if(status>0){
	   System.out.println("status="+status);
	   System.out.println("record deleted successfully");
	   response.sendRedirect("login.jsp");
}else{
	   System.out.println("status="+status);
	   System.out.println("Sorry! unable to delete record"); 
	   response.sendRedirect("profile_page1.jsp");
}

%>
</body>
</html>