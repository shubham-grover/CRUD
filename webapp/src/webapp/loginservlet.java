package webapp;

import java.io.IOException;
import java.util.List;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.servlet.http.HttpSessionListener;
import javax.resource.cci.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Statement;

@WebServlet("/loginservlet")
public class loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 
       
	 protected void doPost(HttpServletRequest request, HttpServletResponse response)  
             throws ServletException, IOException { 
 response.setContentType("text/html");  
 PrintWriter out=response.getWriter();  
 String E=request.getParameter("Email");  
 String p=request.getParameter("password");  


 int _id = newuserdao.login(E,p);
 
/* HttpSession session=request.getSession(true); 
 request.setAttribute("_id",_id);*/
// if(session!=null){ 
 if(_id != 0)
 {      // response.sendRedirect(/*"viewservlet""loginservlet"*/"profilepage"); 
	/* */
	// out.println("id ="+_id);
	    HttpSession session=request.getSession(true); 
	    session.setAttribute("sid",_id);
	    employee e=newuserdao.getEmployeeById(_id);
	    out.println("<h2 align='center'><b><u> logged in with, "+ E +"</u></b></h2><br/>");
	    out.println("<br>");
	    
	    out.print("<form action='add_editservlet1?id="+e.getId()+"' method='post'>");
	    out.print("<input type='submit' value='add more details'/>");
	    out.print("</form>");
	    
	    out.print("<form action='view_complete_detail?id="+e.getId()+"' method='post'>"); 
		out.print("<input type='submit' value='view complete details'>");
		out.print("</form>");
		
		out.print("<form  method='post'>"); 
		out.print("<a href='newtask.jsp' >add new task</a>");
		out.print("</form>");
		
		out.print("<form action='logout' method='post'>"); 
		out.print("<input type='submit' value='LOGOUT'>"/*<a href='index.html' ></a>*/);
		out.print("</form>");
		out.println("<br>");
		
		out.print("<br>");
		 out.print("<table border='1' width='80%' align='center'>");  
	        out.print("<tr><th>Id</th><th>firstName</th><th>lastName</th><th>Email</th><th>gender</th><th>age</th><th>Edit</th><th>Delete</th></tr>");  
	        
	         out.print("<tr><td>"+e.getId()+"</td><td>"+e.getfirstName()+"</td><td>"+e.getlastName()+"</td><td>"+e.getEmail()+"</td><td>"/*+e.getPassword()+"</td>"<td>"*/+e.getgender()+"</td><td>"+e.getAge()+"</td><td><form action='UpdateDetails?id="+e.getId()+"' method='post'><input type='submit' value='edit'/></form></td>  <td><form action='Delete_complete_details?id="+e.getId()+"' method='post'><input type='submit' value='delete'/></form></td></tr>");  
	      
	        out.print("</table>");
	        
	  
	        List<task> list=newuserdao.showtask(_id);
	        out.print("<br>");
	        out.print("<table border='1' width='80%'  align='center'>");  
	        out.print("<tr><th>task id</th><th>task name</th><th>resolving time</th><th>status</th><th>user_Id</th><th>Edit task</th><th>Delete</th></tr>");  
	        for(task t:list){  
	         out.print("<tr><td>"+t.getTask_id()+"</td><td>"+t.getTask_name()+"</td><td>"+t.getResolving_time()+"</td><td>"+t.getStatus()+"</td><td>"+t.getid()+"<td><form action='EditTask?Task_id="+t.getTask_id()+"' method='post'><input type='submit' value='edit task'/></form></td>  <td><form action='DeleteTask?Task_id="+t.getTask_id()+"' method='post'><input type='submit' value='delete task'/></form></td></tr>");  
	        }  
	        out.print("</table>");
	        

 }  
 else{  
     out.print("<p><b> Sorry, username,email or password error!</b></p>");  
     request.getRequestDispatcher("index.html").include(request, response);  
 } 
 
 out.close();  
}
	 @Override
	    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    	
	    	doPost(req, resp);
	    }
}
