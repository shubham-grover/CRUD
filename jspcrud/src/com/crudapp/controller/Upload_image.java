package com.crudapp.controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.crupapp.dao.UserDao;



/**
 * Servlet implementation class Upload_image
 */
@WebServlet("/Upload_image")
public class Upload_image extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 protected void doPost(HttpServletRequest request, HttpServletResponse response)  
             throws ServletException, IOException {

		 Part filePart=request.getPart("image");
		 System.out.println("filepart.. :-"+filePart);
		 System.out.println("filepart.. :-"+request.getParameter("image"));
		 
		 int id=(Integer) request.getSession().getAttribute("id");
		 System.out.println("id of user.... :-"+id);
		// int id=Integer.parseInt(sid);
		 try
		 {
			 System.out.println("in try block    -------------");
			 Enumeration atr_names = request.getSession().getAttributeNames();
			 while(atr_names.hasMoreElements())
			 {
				 System.out.println("Attributes name - "+atr_names.nextElement());
			 }
			 
			  atr_names = request.getParameterNames();
			 while(atr_names.hasMoreElements())
			 {
				 System.out.println("Parameter names - "+atr_names.nextElement());
			 }
			 
			 if(filePart !=null){
				 System.out.println(filePart.getName());
				 System.out.println(filePart.getSize());
				 System.out.println(filePart.getContentType());
				 
			 }
			 int result=UserDao.uploadimage(filePart,id);
			 if(result>0)
			 {
				 System.out.println("result != 0 ");
				 System.out.println("image uploaded successfully ");
				 response.sendRedirect("profile_page1.jsp?message=Image+Uploaded");
			 }
			 else{
				 //printStackTrace();
				 System.out.println("result != 1 ");
				 System.out.println("sorry! image not uploaded");
				 response.sendRedirect("index.jsp?message=some+error+occured");
			 }
		 }catch(Exception e){
			 e.printStackTrace();
			 
		         }
	 }
}
