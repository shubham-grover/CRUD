package webapp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Delete_complete_details
 */
@WebServlet("/Delete_complete_details")
public class Delete_complete_details extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 protected void doPost(HttpServletRequest request, HttpServletResponse response)   
             throws ServletException, IOException { 
		 
        String sid=request.getParameter("id");  
        int id=Integer.parseInt(sid);
        int status1= newuserdao.delete_extra_details(id);
       int status= newuserdao.delete(id);
      // int status1= newuserdao.delete_extra_details(id);
        if(status>0 && status1>0){  
        	
        	
        	 System.out.println("record deleted successfully");  
        	
        	response.sendRedirect("loginservlet");
        	
          //  request.getRequestDispatcher("loginservlet").include(request, response);  

        }else{  
           System.out.println("Sorry! unable to delete record");  
        }  
          
        
        }  
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	doPost(req, resp);
    }


}
