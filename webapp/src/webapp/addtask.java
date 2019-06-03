package webapp;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addtask")
public class addtask extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	 
	    	doPost(req, resp);
	    }
	
	
	    protected void doPost(HttpServletRequest request, HttpServletResponse response)   
		           throws ServletException, IOException {  
	    	
	    	    response.setContentType("text/html");  
		        PrintWriter out=response.getWriter(); 
		        
		     request.getSession(true).getAttribute("sid");
		        
		     out.println("<h1>Add new task for Employee</h1>"); 
		          
		        int status=0;  
		      //  employee e=newuserdao.getEmployeeById(id); 
		        String Task_name=request.getParameter("Task_name");
		        String Resolving_time=request.getParameter("Resolving_time"); 
		        String Status=request.getParameter("Status"); 
		       
		     
		         
		           int _id=(int)request.getSession().getAttribute("sid");
		           
		      
		       
		    
		        task t=new task();  
		       // t.setTask_id(Task_id);
		        t.setTask_name(Task_name);
		        t.setResolving_time(Resolving_time); 
		        t.setStatus(Status);  
		        t.setid(_id); 
		          
		         status=newuserdao.add_task(t); 
		        
		        if(status>0){  
		            System.out.println("<p>Record saved successfully!</p>");  
		            response.sendRedirect("loginservlet");
		           // request.getRequestDispatcher("loginservlet").include(request, response);  
		        }else{  
		            System.out.println("Sorry! unable to save task");  
		        }  
		        out.close();  
	
	
}

}	    
