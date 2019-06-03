package webapp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Editservlet")
public class Editservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	 @Override
	    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    	 
	    	doPost(req, resp);
	    }
	
	
	    protected void doPost(HttpServletRequest request, HttpServletResponse response)   
		           throws ServletException, IOException {  
	    	
	    	
	    	
	    	
	    //System.out.println("in Editservlet");
		        response.setContentType("text/html");  
		        PrintWriter out=response.getWriter();  
		        out.println("<h1>Update Employee</h1>");  
		        String sid=request.getParameter("id");  
		        int id=Integer.parseInt(sid);  
		          
		        employee e=newuserdao.getEmployeeById(id);  
		          
		        out.print("<form action='Editservlet2' method='post'>");  
		        out.print("<table>");  
		        out.print("<tr><td></td><td><input type='hidden' name='id' value='"+e.getId()+"'/></td></tr>");  
		        out.print("<tr><td>firstName:</td><td><input type='text' name='firstname' value='"+e.getfirstName()+"'/></td></tr>");
		        out.print("<tr><td>lastName:</td><td><input type='text' name='lastname' value='"+e.getlastName()+"'/></td></tr>");
		        out.print("<tr><td>Email:</td><td><input type='email' name='email' value='"+e.getEmail()+"'/></td></tr>");
		        out.print("<tr><td>Password:</td><td><input type='password' name='password' value='"+e.getPassword()+"'/></td></tr>");  
		        out.print("<tr><td>gender:</td><td><input type='text' name='gender' value='"+e.getgender()+"'/></td></tr>");
		        out.print("<tr><td>Age:</td><td><input type='text' name='age' value='"+e.getAge()+"'/></td></tr>");  
		        out.print("</td></tr>");  
		        out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");  
		        out.print("</table>");  
		        out.print("</form>");  
		          
		        out.close();  
		    }  

}
