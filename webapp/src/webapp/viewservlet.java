package webapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

@WebServlet("/viewservlet")
public class viewservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
		    protected void doPost(HttpServletRequest request, HttpServletResponse response)   
		               throws ServletException, IOException {  
		    	
		    	
		    	
		    	System.out.println(request.getParameterNames());
		    	//request.getParameterValues(name)[0] = "newValue"
		    	
		    	  //System.out.println("in viewservlet");
		        response.setContentType("text/html");  
		        PrintWriter out=response.getWriter();  
		        out.println("<a href='newuser.html'>Add New Employee</a>");
		       /* out.println("<button type='button' onclick='newuser.html'>add new employee</button>");*/
		        out.println("<h1>Employees List</h1>");  
		          
		        List<employee> list=newuserdao.getAllemployees();  
		          
		        out.print("<table border='1' width='100%'>");  
		        out.print("<tr><th>Id</th><th>firstName</th><th>lastName</th><th>Email</th><th>gender</th><th>age</th><th>Edit</th><th>Delete</th></tr>");  
		        for(employee e:list){  
		         out.print("<tr><td>"+e.getId()+"</td><td>"+e.getfirstName()+"</td><td>"+e.getlastName()+"</td><td>"+e.getEmail()+"</td><td>"/*+e.getPassword()+"</td>"<td>"*/+e.getgender()+"</td><td>"+e.getAge()+"</td><td><form action='Editservlet?id="+e.getId()+"' method='post'><input type='submit' value='edit'/></form></td>  <td><form action='deleteservlet?id="+e.getId()+"' method='post'><input type='submit' value='delete'/></form></td></tr>");  
		        }  
		        out.print("</table>");  
		          
		        out.close();  
		    }  
		    @Override
		    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		    	
		    	doPost(req, resp);
		    }

}
