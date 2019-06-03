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

 <!--<jsp:useBean id="user" class="com.crudapp.bean.User"></jsp:useBean>  
<jsp:setProperty property="*" name="user"/>  -->
<jsp:useBean id="u" class="com.crudapp.bean.User"></jsp:useBean>  
<jsp:setProperty property="*" name="u"/>  
<%int _id=(int)request.getSession().getAttribute("id");
request.getSession().setAttribute("id",_id);
System.out.println("id for edit_info2="+_id);
		//User u=new User();
		u.setId(_id);
int status=UserDao.Edit_info(u);  
if(status>0){  
	System.out.print("status="+status);
	System.out.println("\n updation successful");
response.sendRedirect("profile_page1.jsp");  
}else{  
	System.out.print("status="+status);
	System.out.println("\n sorry! unable to update,please try again...");%>

     <script>
	 alert("sorry! unable to register,please try again...");		
	 </script>
<% response.sendRedirect("profile_page1.jsp");  
} 
%>
</body>
</html>