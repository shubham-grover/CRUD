package webapp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateDetails
 */
@WebServlet("/UpdateDetails")
public class UpdateDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	 
	    	doPost(req, resp);
	    }
	  protected void doPost(HttpServletRequest request, HttpServletResponse response)   
	           throws ServletException, IOException {  
   	
   	 response.setContentType("text/html");  
	        PrintWriter out=response.getWriter();  
	        out.println("<h1>Update details of Employee</h1>"); 
	        String sid=request.getParameter("id");  
	        int id=Integer.parseInt(sid);  
	        employee e=newuserdao.getEmployeeById(id);  
	        add_details a=newuserdao.showDetailsById(id) ;
	        out.print("<form action='UpdateDetails2?id="+e.getId()+"' method='post'>");  
	        out.print("<table>");  
	        out.print("<tr><td></td><td><input type='hidden' name='id' value='"+e.getId()+"'/></td></tr>");  
	        out.print("<tr><td>firstName:</td><td><input type='text' name='firstname' value='"+e.getfirstName()+"'/></td></tr>");
	        out.print("<tr><td>lastName:</td><td><input type='text' name='lastname' value='"+e.getlastName()+"'/></td></tr>");
	        out.print("<tr><td>Email:</td><td><input type='email' name='email' value='"+e.getEmail()+"'/></td></tr>");
	        out.print("<tr><td>Password:</td><td><input type='password' name='password' value='"+e.getPassword()+"'/></td></tr>");  
	        out.print("<tr><td>gender:</td><td><input type='text' name='gender' value='"+e.getgender()+"'/></td></tr>");
	        out.print("<tr><td>Age:</td><td><input type='text' name='age' value='"+e.getAge()+"'/></td></tr>");
	       
	        out.print("<tr><td>mobile number:</td><td><input type='text' name='phone_no' value='"+a.getphone_no()+"'/></td></tr>");
	        out.print("<tr><td>salary:</td><td><input type='text' name='salary' value='"+a.getsalary()+"'/></td></tr>");
	        out.print("<tr><td>city:</td><td><input type='text' name='city' value='"+a.getcity()+"'/></td></tr>");
	        out.print("<tr><td>state:</td><td><input type='text' name='state' value='"+a.getstate()+"'/></td></tr>");
	        out.print("<tr><td>country:</td><td><input type='text' name='country' value='"+a.getcountry()+"'/></td></tr>");
	        out.print("<tr><td>department:</td><td><input type='text' name='department' value='"+a.getdepartment()+"'/></td></tr>");
	        out.print("<tr><td></td><td><input type='hidden' name='id' value='"+a.getId()+"'/></td></tr>");
	        out.print("</td></tr>");  
	        out.print("<tr><td colspan='2'><input type='submit' value='Save '/></td></tr>");  
	        out.print("</table>");  
	        out.print("</form>");  
	          
	        out.close();  
   } 
   

}
