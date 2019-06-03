package webapp;

import java.io.IOException;

import java.io.PrintWriter;  
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			        response.setContentType("text/html");  
			        PrintWriter out=response.getWriter();  
			          System.out.println("in register servlet");
			        String firstname=request.getParameter("firstname");
			        String lastname=request.getParameter("lastname"); 
			        String password=request.getParameter("password");  
			        String email=request.getParameter("email");  
			        String gender=request.getParameter("gender");
			        String agee=request.getParameter("age");
			        int age = Integer.parseInt(agee); 
			        employee e=new employee();  
			        e.setfirstName(firstname);
			        e.setlastName(lastname); 
			        e.setPassword(password);  
			        e.setEmail(email);  
			        e.setgender(gender);
			        e.setAge(age); 
			          
			        int status=newuserdao.save(e); 
			        
			        if(status>0){  
			            System.out.println("<p>Record saved successfully!</p>");  
			            request.getRequestDispatcher("index.html").include(request, response);  
			        }else{  
			            System.out.println("Sorry! unable to save record");  
			        }  
			        out.close();  

	}
	

}
