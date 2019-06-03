package com.crupapp.dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.servlet.http.Part;

import com.crudapp.bean.User;
import com.mysql.jdbc.PreparedStatement;



public class UserDao {
	 public static Connection getConnection(){  
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
	    }  
	  
	 public static int save(User u){  
		    int status=0;  
		    try{  
		        Connection con=getConnection();  
		        PreparedStatement ps=(PreparedStatement) con.prepareStatement(  
		        "insert into newuser(username,email,password,gender,age,country) values(?,?,?,?,?,?)");  
		        //ps.setInt(1,u.getId());
		        System.out.println(u.getname());
		        
		        ps.setString(1,u.getname()); 
		        ps.setString(2,u.getEmail());  
		        ps.setString(3,u.getPassword());  
		        ps.setString(4,u.getgender());  
		        ps.setInt(5,u.getAge());
		        ps.setString(6,u.getcountry());  
		        status=ps.executeUpdate();  
		        con.close();
		    }catch(Exception e){
		    	e.printStackTrace();
		    	System.out.println(e);}  
		    return status;  
		}  

		public static int login(String E, String p) {
			// TODO Auto-generated method stub
			//boolean status=false;
			try{ 
				Connection con=getConnection(); 
				 PreparedStatement ps=(PreparedStatement) con.prepareStatement("select user_id from newuser where Email=? and password=?");
				 ps.setString(1,E.trim());
				 ps.setString(2,p.trim());
				 System.out.println("in userdao login(),email:"+E);
				 System.out.println("in userdao login(),password:"+p);
				 //ps.setInt(id);
				 ResultSet rs=ps.executeQuery();
				 if(rs.next())
				 {
					 return rs.getInt(1);
				 }
//				  status = rs.next();
				 con.close();
			}
			catch(Exception e){
				e.printStackTrace();
				System.out.println(e);}
			return 0;
			
		}
		public static User show_info(int id)
		{
			User u=new User();
			try{ 
				Connection con=getConnection(); 
				 PreparedStatement ps=(PreparedStatement) con.prepareStatement("select * from newuser where user_id=?");
				 ps.setInt(1,id);  
	 	            ResultSet rs=ps.executeQuery();  
	 	            if(rs.next()){  
	 	                u.setId(rs.getInt(1));  
	 	                u.setname(rs.getString(2));
	 	                u.setEmail(rs.getString(3));
	 	                u.setPassword(rs.getString(4));    
	 	                u.setgender(rs.getString(5));
	 	                u.setAge(rs.getInt(6));
	 	                u.setcountry(rs.getString(7));
	 	            }  
				 con.close();
			    }catch(Exception e){
					e.printStackTrace();
					System.out.println(e);}
				 return u;
		}

		public static int uploadimage(Part filePart, int id) {
			// TODO Auto-generated method stub
			int result=0;
			InputStream is=null;
			if(filePart!=null)
			{
				try{
					Connection con=getConnection(); 
					 PreparedStatement ps=(PreparedStatement) con.prepareStatement("insert into profile(image,user_id)values(?,?)");
					 is=filePart.getInputStream();
					 ps.setBlob(1, is);
					 ps.setInt(2, id);
					 result =ps.executeUpdate();
					 System.out.println("result is :-"+result);
					 
				}catch(Exception e){
					e.printStackTrace();
					System.out.println(e);}
			}
			return result;
		}
		
		public static int Edit_info(User u){
			int status=0;
			 try{  
			        Connection con=getConnection();  
			        PreparedStatement ps=(PreparedStatement) con.prepareStatement(  
			        "update newuser set username=?,email=?,gender=?,age=?,country=? where user_id=?");  
			        //ps.setInt(1,u.getId());
			        System.out.println("username="+u.getname());
			        System.out.println("email="+u.getEmail());
			        System.out.println("password="+u.getPassword());
			        System.out.println("gender="+u.getgender());
			        System.out.println("age="+u.getAge());
			        System.out.println("country="+u.getcountry());
			        System.out.println("user_id="+u.getId());
			        ps.setString(1,u.getname()); 
			        ps.setString(2,u.getEmail());  
			       // ps.setString(3,u.getPassword());  
			        ps.setString(3,u.getgender());  
			        ps.setInt(4,u.getAge());
			        ps.setString(5,u.getcountry()); 
			        ps.setInt(6,u.getId());
			        status=ps.executeUpdate();  
			        con.close();
			    }catch(Exception e){
			    	e.printStackTrace();
			    	System.out.println(e);}  
			    return status;  
			
			
		}
		public static int delete_info(int id){
			int status=0;
			try{Connection con=getConnection(); 
			 PreparedStatement ps=(PreparedStatement) con.prepareStatement("delete from newuser where user_id=?");
			 System.out.println("deleting process for id="+id );
			 ps.setInt(1,id);  
			 status=ps.executeUpdate();
			 con.close();
				
			}catch(Exception e){
				e.printStackTrace();
				System.out.println(e);
			}
			return status;
			
		}
	
}
