package webapp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditTask
 */
@WebServlet("/EditTask")
public class EditTask extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	 
	    	doPost(req, resp);
	    }
	 protected void doPost(HttpServletRequest request, HttpServletResponse response)   
	           throws ServletException, IOException{
		 response.setContentType("text/html");  
	        PrintWriter out=response.getWriter();  
	        out.println("<h1>Edit Task of Employee</h1>"); 
	        String tid=request.getParameter("Task_id");  
	        int Task_id=Integer.parseInt(tid);  
	        task t=newuserdao.getTask_by_taskId(Task_id);
	        out.print("<form action='EditTask2?Task_id="+t.getTask_id()+"' method='post'>");
	        out.print("<table>");
	        out.print("<tr><td></td><td><input type='hidden' name='Task_id' value='"+t.getTask_id()+"'/></td></tr>");  
	        out.print("<tr><td>Task_Name:</td><td><input type='text' name='Task_name' value='"+t.getTask_name()+"'/></td></tr>");
	        out.print("<tr><td>Resolving_Time:</td><td><input type='text' name='Resolving_time' value='"+t.getResolving_time()+"'/></td></tr>");
	        out.print("<tr><td>Status:</td><td><input type='text' name='Status' value='"+t.getStatus()+"'/></td></tr>");
	        out.print("</td></tr>");  
	        out.print("<tr><td colspan='2'><input type='submit' value='update & Save '/></td></tr>");  
	        out.print("</table>");  
	        out.print("</form>");  
	          
	        out.close();  
	 }
}
