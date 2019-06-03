package webapp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/profilepage")
public class profilepage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException { 
response.setContentType("text/html");  
PrintWriter out=response.getWriter();
String E=request.getParameter("Email");  
String p=request.getParameter("password");  
int _id = newuserdao.login(E,p);
if(_id != 0)
{
out.print("<form action='logout' method='post'>"); 
out.print("<input type='submit' value='LOGOUT'><a href='index.html' ></a>");
out.print("</form>");
out.println("<br>");
out.println("\n \t  logged in with, "+E);
out.print("\n");
out.print("\n");
HttpSession session=request.getSession();  
session.setAttribute("Email",E); 

employee e=newuserdao.getEmployeeById(_id);
out.print("<br>");
 out.print("<table border='1' width='100%'");  
    out.print("<tr><th>Id</th><th>firstName</th><th>lastName</th><th>Email</th><th>gender</th><th>age</th><th>Edit</th><th>Delete</th></tr>");  
    //for(employee e:list){  
     out.print("<tr><td>"+e.getId()+"</td><td>"+e.getfirstName()+"</td><td>"+e.getlastName()+"</td><td>"+e.getEmail()+"</td><td>"/*+e.getPassword()+"</td>"<td>"*/+e.getgender()+"</td><td>"+e.getAge()+"</td><td><form action='Editservlet?id="+e.getId()+"' method='post'><input type='submit' value='edit'/></form></td>  <td><form action='deleteservlet?id="+e.getId()+"' method='post'><input type='submit' value='delete'/></form></td></tr>");  
    //}  
    out.print("</table>"); 
}
out.close();  
}
	
	 @Override
	    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    	
	    	doPost(req, resp);
	    }
}
