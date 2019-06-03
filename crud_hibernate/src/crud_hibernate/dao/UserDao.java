package crud_hibernate.dao;


import com.crud_hibernate.User;

import java.sql.Connection;
import java.sql.DriverManager;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.impl.SessionFactoryImpl;

public class UserDao {
	/* public static Connection getConnection(){  
	        Connection con=null;  
	        String url = "jdbc:mysql://localhost:3306/jspcrud";
	        String username = "root";
	        String pass = "";
	        try{  
	            Class.forName("com.mysql.jdbc.Driver");  
	            con=DriverManager.getConnection(url,username,pass);  
	        }catch(Exception e){
	        	e.printStackTrace();
	        	System.out.println(e);}  
	        return con;  
	    }  */
	public static int register(User u){  
		 int i=0;  
		 UserDao dao = new UserDao();
		 System.out.println("in register method of UserDao");
		 Session session = null;
		 try
		 {
			 
			 session = dao.getSession();
			 System.out.println("session established="+session);
			          
			  Transaction transaction=session.beginTransaction();  
			  transaction.begin();  
			                  
			  i=(Integer)session.save(u);  
			                  
			  transaction.commit();
		 }
		 catch (Exception e) 
		 {
			 e.printStackTrace();
		 }
		 finally
		 {
			  session.close();  
			  System.out.println("Session closed successfully");
		 }  
		  return i;  
		 } 
	public Session getSession()
	{	System.out.println("in getSession method of UserDao");
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory session_factory = cfg.buildSessionFactory();
		Session session = session_factory.openSession();
		return session;
	}
	
	
}
