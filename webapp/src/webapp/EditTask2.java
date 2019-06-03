package webapp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditTask2
 */
@WebServlet("/EditTask2")
public class EditTask2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	 
	    	doPost(req, resp);
	    }
	 protected void doPost(HttpServletRequest request, HttpServletResponse response)   
	          throws ServletException, IOException{
		 response.setContentType("text/html");  
	        PrintWriter out=response.getWriter(); 
	        String tid=request.getParameter("Task_id");  
	        int Task_id=Integer.parseInt(tid);  
	        System.out.println("Task_name - in edit servlet - "+request.getParameter("Task_name"));
	        String Task_name=request.getParameter("Task_name");
	        String Resolving_time=request.getParameter("Resolving_time");
	        String Status=request.getParameter("Status"); 
	        task t=new task();
	        t.setTask_id(Task_id);
	        t.setTask_name(Task_name);
	        t.setResolving_time(Resolving_time);
	        t.setStatus(Status);
	        
	        int status2=newuserdao.Edit_Task(t);
	        if(status2>0)
	        {
	        	System.out.println("Task updation successful");
	        	out.println("Task updation successful");
	        	response.sendRedirect("loginservlet");
	        	
	        }
	        else{  
	            out.println("Sorry! unable to update Task");  
	        }  
	          
	        
	        
	        
	        
	        
	        out.close();  
	 }

}
