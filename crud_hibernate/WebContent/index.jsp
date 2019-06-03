<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>index page</title>
</head>
<style>
input[type="text"],input[type="Email"],input[type="password"], select {
    width: 100%;
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
<body style="background-color:#ccffcc;">
<div align="center">
<form action="register.jsp" method="post">  
User_Name:<input type="text" name="name" placeholder="Your username" required="required"/><br><br/>  
Email_ID:<input type="text" name="email" placeholder="Your Email address" required="required"/><br><br/>  
Password:<input type="password" name="password"  placeholder="Your password" required="required"/><br><br/> 
<input type="submit" value="register"/>  
</form>
</div> 
</body>
</html>