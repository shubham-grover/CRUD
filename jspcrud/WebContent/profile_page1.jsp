<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.crupapp.dao.UserDao"%>
    <%@page import="com.crudapp.bean.User"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>profile page1</title>
<style>
body{
background-image: url("C:\Users\hp\workspace\jspcrud\gokuSSJ3.jpg");

}
</style>
</head>
<body  style="background-color:#ccccff;">
<jsp:useBean id="user" class="com.crudapp.bean.User"></jsp:useBean>  
<jsp:setProperty property="*" name="user"/>  
<%
/*String E=request.getParameter("Email");
out.println("logged in with:-"+E);*/
int _id=(int)request.getSession().getAttribute("id");
request.getSession().setAttribute("id",_id);
System.out.print("in profile_page1.jsp,user_id:"+_id);
//int id=Integer.parseInt("sid");
System.out.println("id="+_id);
User u=UserDao.show_info(_id);

%>
<form action="logout.jsp" method="post">
	<input type="submit" value="logout" name="logout"/>	
</form>
&nbsp;
<form action="edit_info.jsp" method="post">
	<input type="submit" value="edit_info" name="edit_info">
</form>
&nbsp;
<form action="Delete_info.jsp" method="post">
	<input type="submit" value="Delete_info" name="Delete_info">
</form>

<div align="right">
   <form action="Upload_image" method="post" enctype="multipart/form-data">
          profile pic:  <input type="file" name="image" required="required"/><br/><br/>
            <input type="submit"/>
        </form>
  
</div>
<table align="center">
	<tr>
		<td><b>User_id:</b></td>
		<td><%=u.getId() %></td>
	</tr>
	<tr>
		<td><b>Name:</b></td>
		<td><%=u.getname() %></td>
	</tr>
	<tr>
		<td><b>Email:</b></td>
		<td><%=u.getEmail() %></td>
	</tr>
	<tr>
		<td><b>Gender:</b></td>
		<td><%=u.getgender() %></td>
	</tr>
	<tr>
		<td><b>Age:</b></td>
		<td><%=u.getAge() %></td>
	</tr>
	<tr>
		<td><b>Country:</b></td>
		<td><%out.print(u.getcountry()); %></td>
	</tr>
	
</table>

</body>
</html>