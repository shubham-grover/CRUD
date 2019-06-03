<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="com.crupapp.dao.UserDao"%> 
     <%@page import="com.crudapp.bean.User"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>edit details</title>
</head>
<style>
input[type="text"],input[type="Email"],input[type="password"], select {
    width: 110%;
    padding: 12px 20px;
    margin: 8px 0;
    display:inline-block;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
}

input[type=submit] {
    width: 100%;
    background-color: #4CAF50;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}

input[type=submit]:hover {
    background-color: #45a049;
}

div {
position: relative;
  font-size: 16px;
  height: auto;
/** margin-top: 80px;
  margin-bottom: 80px;*/
  margin:auto;
    max-width: 380px;
    padding: 15px 35px 45px;
    border-radius: 5px;
    background-color: #f2f2f2;
  /**  padding: 20px; **/
}
</style>
<body style="background-color:powderblue;">
<jsp:useBean id="user" class="com.crudapp.bean.User"></jsp:useBean>  
<jsp:setProperty property="*" name="user"/>  
<%
/*String E=request.getParameter("Email");
out.println("logged in with:-"+E);*/
int _id=(int)request.getSession().getAttribute("id");
request.getSession().setAttribute("id",_id);
//int id=Integer.parseInt("sid");
System.out.println("id for edit_info="+_id);
User u=UserDao.show_info(_id);

%>
<div align="center">
	<form action="edit_info2.jsp" method="post">
		<table >
			<tr>
				<td><b>Name:</b></td>
				<td><input type="text" name="name" value=<%=u.getname() %>></td>
			</tr>
			<tr>
		<td><b>Email:</b></td>
		<td><input type="text" name="email" value=<%=u.getEmail() %>></td>
	</tr>
	<tr>
		<td><b>Gender:</b></td>
		<td><input type="text" name="gender" value=<%=u.getgender() %>></td>
	</tr>
	<tr>
		<td><b>Age:</b></td>
		<td><input type="text" name="age" value=<%=u.getAge() %>></td>
	</tr>
	<tr>
		<td><b>Country:</b></td>
		<td><input type="text" name="country" value=<%out.print(u.getcountry()); %>></td>
	</tr>
	<tr><td colspan="2" align="center"><input type="submit" value="edit & Save"/></td></tr>
		</table>
		
	</form>


</div>
</body>
</html>