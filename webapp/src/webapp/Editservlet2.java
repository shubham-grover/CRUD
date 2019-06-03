package webapp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Editservlet2")
public class Editservlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
		    protected void doPost(HttpServletRequest request, HttpServletResponse response)   
		          throws ServletException, IOException {  
		    	System.out.println("in Editservlet");
		    	
		        response.setContentType("text/html");  
		        PrintWriter out=response.getWriter();  
		          
		        String sid=request.getParameter("id");  
		        int id=Integer.parseInt(sid);  
		        String firstname=request.getParameter("firstname");
		        String lastname=request.getParameter("lastname");
		        String password=request.getParameter("password");  
		        String email=request.getParameter("email");  
		        String gender=request.getParameter("gender");  
		        String agee=request.getParameter("age");
		        int age = Integer.parseInt(agee); 
		        employee e=new employee();  
		        e.setId(id);  
		        e.setfirstName(firstname);
		        e.setlastName(lastname);
		        e.setEmail(email);
		        e.setPassword(password);  
		        e.setgender(gender);  
		        e.setAge(age);  
		        int status=newuserdao.update(e);  
		        if(status>0){  
	            response.sendRedirect("viewservlet"/*"loginservlet""profilepage"*/);  
     	        }else{  
		            out.println("Sorry! unable to update record");  
    	        }  
		          
		        out.close();  
		    } 
		    
		    @Override
		    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		    	
		    	doPost(req, resp);
		    }


}
