<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>registration from</title>
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

<body style="background-color:#009933;">
<script>  
function validate(){  
var num=document.myform.num.value;  
if (isNaN(num)){  
  document.getElementById("numloc").innerHTML="Enter Numeric value only";  
  return false;  
}else{  
  return true;  
  }  
}  
</script> 
<div>
<form  onsubmit="return validate()" action="register.jsp" method="post">
 <h2 align="center"><b><u>Registration Form</u></b></h2>
     <table align="center">
            <tr>
               <td> <label for="name">Name: </label> </td>
               <td> <input type="text" id="name" name="name"/>  </td>
            </tr>  
           
            <tr>
            	<td> <label for="email">Email: </label> </td>
            	<td><input type="email" id="email" name="email" required="required"/></td>
            </tr>
            <tr>
            	<td> <label for="password">Password: </label>  </td>
            	<td>  <input type="password" id="password" name="password" required="required"/></td>
            	
            </tr>
            <tr>
            	<td> <label for="gender">Gender: </label></td>
                <td> <input type="radio" id="gender" name="gender" value="male"/>Male
                 <input type="radio" id="gender" name="gender" value="female"/>Female</td>
            </tr>
            <tr>
            	<td> <label for="age">Age: </label></td>
            	<td><input type="text" name="age"><span id="numloc"></span></td>
            </tr>
            <tr>
            	<td><label for="country">Country:</label></td>
            	<td><select name="country" style="width:150px">
            		<option>INDIA</option>
            		<option>USA</option>
            		<option>ENGLAND</option>
            		<option>CANADA</option>
            		<option>AUSTRALIA</option>
            		<option>PARIS</option>
            		<option>GERMANY</option>
            		<option>ITALY</option>
            		<option>SPAIN</option></select>
            	</td>
            </tr>
            
           <tr>
            	<td colspan="2"><input type="submit" value="register"/></td>
           </tr>
            
     </table>
</form>

 <form action="login.jsp">
  				<input type="submit" value="sign in"/></form> 
  </div> 
</body>
</html>