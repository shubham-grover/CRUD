<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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

<body>
<div>
<%

%>

<form action="addtask?id="+e.getId()+"" method="post">
 <!-- <label for="Task_id">Task Id: </label>  
              <input type="number" id="Task_id" name="Task_id"/> <br/>  -->
 <label for="Task_name">Task Name: </label>  
              <input type="text" id="Task_name" name="Task_name"/> <br/>  
 <label for="Resolving_time">Resolving time: </label>  
              <input type="text" id="Resolving_time" name="Resolving_time"/> <br/> 
  <label for="Status">Status: </label>  
              <input type="text" id="Status" name="Status"/> <br/>  
          <input type="submit" value="save task"/>                          
</form>
</div>
</body>
</html>