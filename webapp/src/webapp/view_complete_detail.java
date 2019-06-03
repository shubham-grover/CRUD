package webapp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class view_complete_detail
 */
@WebServlet("/view_complete_detail")
public class view_complete_detail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	  protected void doPost(HttpServletRequest request, HttpServletResponse response)   
              throws ServletException, IOException{
		 // System.out.println(request.getParameterNames());
	    	
	        response.setContentType("text/html");  
	        PrintWriter out=response.getWriter(); 
	        String sid=request.getParameter("id");
	      //  System.out.println("sid ::"+sid);
	        
	        int id=Integer.parseInt(sid);  
	        employee e=newuserdao.getEmployeeById(id);  
	        add_details a=newuserdao.showDetailsById(id) ;
	        out.print("<table border='1' width='50%' align='center'>");  
	        out.print("<tr><td></td><td><input type='hidden' name='id' value='"+e.getId()+"'/></td></tr>");  
	        out.print("<tr><td>firstName</td><td>"+e.getfirstName()+"</td></tr>");
	        out.print("<tr><td>lastName</td><td>"+e.getlastName()+"</td></tr>");
	        out.print("<tr><td>Email</td><td>"+e.getEmail()+"</td></tr>");
	       // out.print("<tr><td>Password</td><td>< type='password'name='password' value='"+e.getPassword()+"'</td></tr>");  
	        out.print("<tr><td>gender</td><td>"+e.getgender()+"</td></tr>");
	        out.print("<tr><td>Age</td><td>"+e.getAge()+"</td></tr>");
	       // out.print("<tr><td></td><td><input type='hidden' name='id' value='"+a.getId()+"'/></td></tr>");
	        out.print("<tr><td>mobile number</td><td>"+a.getphone_no()+"</td></tr>");
	        out.print("<tr><td>salary</td><td>"+a.getsalary()+"</td></tr>");
	        out.print("<tr><td>city</td><td>"+a.getcity()+"</td></tr>");
	        out.print("<tr><td>state</td><td>"+a.getstate()+"</td></tr>");
	        out.print("<tr><td>country</td><td>"+a.getcountry()+"</td></tr>");
	        out.print("<tr><td>department</td><td>"+a.getdepartment()+"</td></tr>");
	        
	        out.print("</td></tr>");  
	       // out.print("<tr><td colspan='2'><input type='submit' value='Save '/></td></tr>");  
	        out.print("</table>");
	        out.print("<form action='UpdateDetails?id="+e.getId()+"' method='post'><input type='submit' value='edit'/></form></td>  <td><form action='Delete_complete_details?id="+e.getId()+"' method='post'><input type='submit' value='delete'/></form>");
	 out.close();
	  }
	  @Override
	    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    	
	    	doPost(req, resp);
	    }
  
}
