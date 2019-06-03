package webapp;

import java.io.IOException;  
import java.io.PrintWriter;  
import javax.servlet.http.HttpSessionListener;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import javax.servlet.http.HttpSession; 
@WebServlet("/logout")
public class logout extends HttpServlet {  
        /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		protected void doPost(HttpServletRequest request, HttpServletResponse response)  
                                throws ServletException, IOException {  
            response.setContentType("text/html");  
            PrintWriter out=response.getWriter(); 
            HttpSession session=request.getSession();
            session.invalidate();
              
            request.getRequestDispatcher("index.html").include(request, response);  
              
            
          //  session.setMaxInactiveInterval(0);
              
            out.print(" <p align='center'><b><i><u> You are successfully logged out!</u></i></b></p></br>");  
              
            out.close();  
    }  
}