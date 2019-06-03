package webapp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class add_editservlet2
 */
@WebServlet("/add_editservlet2")
public class add_editservlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 protected void doPost(HttpServletRequest request, HttpServletResponse response)   
	          throws ServletException, IOException {  
	    	//System.out.println("in Editservlet");
	    	
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
	        String phone=request.getParameter("phone_no");
	        Double phone_no=(double)Double.parseDouble(phone);
	        String salary=request.getParameter("salary");
	        String city=request.getParameter("city");
	        String state=request.getParameter("state");
	        String country=request.getParameter("country");
	        String department=request.getParameter("department");
	        employee e=new employee(); 
	        add_details a=new add_details();
	        e.setId(id);  
	        e.setfirstName(firstname);
	        e.setlastName(lastname);
	        e.setEmail(email);
	        e.setPassword(password);  
	        e.setgender(gender);  
	        e.setAge(age);
	        
	        a.setphone_no(phone_no);
	        a.setsalary(salary);
	        a.setcity(city);
	        a.setstate(state);
	        a.setcountry(country);
	        a.setdepartment(department);
	        a.setId(id);
	        int status=newuserdao.update(e); 
	        int status1=newuserdao.savedetails(a);
	        System.out.println("status- "+status1);
	        if(status>0 && status1>0){  
	        	
	        	
	    
	        	
	        	response.sendRedirect("loginservlet");
	        	
	          //  request.getRequestDispatcher("loginservlet").include(request, response);  
  
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
