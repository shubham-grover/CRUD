package webapp;
	
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;



public class newuserdao {
	
	
	 public static Connection getConnection(){  
	        Connection con=null;  
	        String url = "jdbc:mysql://localhost:3306/webapp";
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
	

	    public static int save(employee e){  
	        int status=0;  
	        try{  
	            Connection con=newuserdao.getConnection();  
                         
                 PreparedStatement ps=con.prepareStatement(  
	                         "insert into newuser(firstname,lastname,Email,password,gender,age) values (?,?,?,?,?,?)");  
	            ps.setString(1,e.getfirstName());
	            ps.setString(2,e.getlastName());
	            ps.setString(3,e.getEmail());
	            ps.setString(4,e.getPassword()); 
	            ps.setString(5,e.getgender());
	            ps.setLong(6,e.getAge());
	              
	             
	              
	            status=ps.executeUpdate();  
	              
	            con.close();  
	        }catch(Exception ex){ex.printStackTrace();}  
	          
	        return status;  
	    }


		public static int login(String E, String p) {
			// TODO Auto-generated method stub
			//boolean status=false;
			try{ 
				 Connection con=newuserdao.getConnection(); 
				 PreparedStatement ps=con.prepareStatement("select id from newuser where Email=? and password=?");
				 ps.setString(1,E.trim());
				 ps.setString(2,p.trim());
				 //ps.setInt(id);
				 ResultSet rs=ps.executeQuery();
				 if(rs.next())
				 {
					 return rs.getInt(1);
				 }
//				  status = rs.next();
				 
			}
			catch(Exception e){
				e.printStackTrace();
				System.out.println(e);}
			return 0;
			
		}


		public static int delete(int id) {
			// TODO Auto-generated method stub
				        int status=0;  
				        try{  
				            Connection con=newuserdao.getConnection();  
				            PreparedStatement ps=con.prepareStatement("delete from newuser where id=?");  
				            ps.setInt(1,id);  
				            status=ps.executeUpdate();  
				              
				            con.close();  
				        }catch(Exception e){e.printStackTrace();}  
				          
				        return status;  
				    }


		public static List<employee> getAllemployees() {
			// TODO Auto-generated method stub
				        List<employee> list=new ArrayList<employee>();  
				          
				        try{  
				            Connection con=newuserdao.getConnection();  
				            PreparedStatement ps=con.prepareStatement("select * from newuser");  
				            ResultSet rs=ps.executeQuery();  
				            while(rs.next()){  
				                employee e=new employee();  
				                e.setId(rs.getInt(1));  
				                e.setfirstName(rs.getString(2));
				                e.setlastName(rs.getString(3));
				                e.setEmail(rs.getString(4));  
				                e.setPassword(rs.getString(5));  
				                e.setgender(rs.getString(6));
				                e.setAge(rs.getInt(7));
				                list.add(e);  
			            }  
				            con.close();  
				        }catch(Exception e){e.printStackTrace();}  
				          
				        return list;  
				      

			
		}


		public static employee getEmployeeById(int _id) {
			// TODO Auto-generated method stub
			 employee e=new employee();  
			 	          
			 	        try{  
			 	            Connection con=newuserdao.getConnection();  
			 	            PreparedStatement ps=con.prepareStatement("select * from newuser where id=?");  
			 	            ps.setInt(1,_id);  
			 	            ResultSet rs=ps.executeQuery();  
			 	            if(rs.next()){  
			 	                e.setId(rs.getInt(1));  
			 	                e.setfirstName(rs.getString(2));
			 	                e.setlastName(rs.getString(3));
			 	                e.setEmail(rs.getString(4));
			 	                e.setPassword(rs.getString(5));    
			 	                e.setgender(rs.getString(6));
			 	                e.setAge(rs.getInt(7));
			 	            }  
			 	            con.close();  
			 	        }catch(Exception ex){ex.printStackTrace();}  
			 	          
			 	        return e;  

			
		}


		public static int update(employee e) {
			// TODO Auto-generated method stub
		    int status=0;  
		    	        try{  
		    	            Connection con=newuserdao.getConnection();  
		    	            PreparedStatement ps=con.prepareStatement(  
		    	                         "update newuser set firstname=?,lastname=?,Email=?,password=?,gender=?,age=? where id=?");  
		    	            ps.setString(1,e.getfirstName());
		    	            ps.setString(2,e.getlastName());
		    	            ps.setString(3,e.getEmail());
		    	            ps.setString(4,e.getPassword());  
		    	              
		    	            ps.setString(5,e.getgender());
		    	            ps.setLong(6,e.getAge());
		    	            ps.setInt(7,e.getId());  
		    	              
		    	            status=ps.executeUpdate();  
		    	              
		    	            con.close();  
		    	        }catch(Exception ex){ex.printStackTrace();}  
		    	          
		    	        return status;  

			
		}  
		public static add_details showDetailsById(int _id) {
			// TODO Auto-generated method stub
			 add_details a=new add_details();  
			 	          
			 	        try{  
			 	            Connection con=newuserdao.getConnection();  
			 	            PreparedStatement ps=con.prepareStatement("select * from Add_details where id=?");  
			 	            ps.setInt(1,_id);  
			 	            ResultSet rs=ps.executeQuery();  
			 	            if(rs.next()){  
			 	               // a.setId(rs.getInt(1));
			 	            	a.setphone_no(rs.getDouble(1));
			 	                a.setsalary(rs.getString(2));
			 	                a.setcity(rs.getString(3));
			 	                a.setstate(rs.getString(4));
			 	                a.setcountry(rs.getString(5));    
			 	                a.setdepartment(rs.getString(6));
			 	                //a.setphone_no(rs.getInt(7));
			 	               a.setId(rs.getInt(7));
			 	            }  
			 	            con.close();  
			 	        }catch(Exception ex){ex.printStackTrace();}  
			 	          
			 	        return a;  

			
		}


		public static int savedetails(add_details a) {
			// TODO Auto-generated method stub
			int status1=0;
			 try{  
 	            Connection con=newuserdao.getConnection();  
 	            PreparedStatement ps=con.prepareStatement(  
 	                         "insert into Add_details values (?,?,?,?,?,?,?)");  
 	            ps.setDouble(1,a.getphone_no());
 	            ps.setString(2,a.getsalary());
 	            ps.setString(3,a.getcity());
 	            ps.setString(4,a.getstate());
 	            ps.setString(5,a.getcountry());  
 	            ps.setString(6,a.getdepartment());
 	           
 	            ps.setInt(7, a.getId());
 	             
 	              
 	            status1=ps.executeUpdate();  
 	              
 	            con.close();  
 	        }catch(Exception ex){ex.printStackTrace();}  
 	          
 	        return status1;  

			
		}


		public static List<task> showtask(int _id) {
			// TODO Auto-generated method stub
			List<task> list=new ArrayList<task>();
			try{
				 Connection con=newuserdao.getConnection();  
		            PreparedStatement ps=con.prepareStatement("select * from tasks where id='" + _id + "'");  
		            ResultSet rs=ps.executeQuery(); 
		            while(rs.next()){
		            task t=new task(); 	
		            t.setTask_id(rs.getInt(1));  
	                t.setTask_name(rs.getString(2));
	                t.setResolving_time(rs.getString(3));
	                t.setStatus(rs.getString(4));  
	                t.setid(rs.getInt(5));
	                list.add(t); 
		            }
		            con.close();
			}catch(Exception e){e.printStackTrace();} 
			
			return list;
		}
		
		public static task getTask_by_taskId(int Task_id){
			task t=new task();
			try{
				 Connection con=newuserdao.getConnection();  
		            PreparedStatement ps=con.prepareStatement("select * from tasks where task_id='" + Task_id + "'");  
		            ResultSet rs=ps.executeQuery(); 
		            while(rs.next()){
		            	    t.setTask_id(rs.getInt(1));  
		            	    System.out.println("returned task name - "+rs.getString(2));
			                t.setTask_name(rs.getString(2));
			                t.setResolving_time(rs.getString(3));
			                t.setStatus(rs.getString(4));  
			                t.setid(rs.getInt(5));
		            }
		            con.close();
		  		}catch(Exception e){e.printStackTrace();} 
			return t;
			
		}
		

		public static int add_task(task t) {
			// TODO Auto-generated method stub//
			int status=0;
			try{ 
				 Connection con=newuserdao.getConnection();  
	 	            PreparedStatement ps=con.prepareStatement(  
	 	                         "insert into tasks(task_name,resolving_time,status,id) values (?,?,?,?)"); 
	 	           // ps.setInt(1,t.getTask_id());
	 	            ps.setString(1,t.getTask_name());
	 	            ps.setString(2,t.getResolving_time());
	 	            ps.setString(3,t.getStatus());
	  	           
	 	            ps.setInt(4,t.getid());
	 	           
	 	            status=ps.executeUpdate();  
	 	              
	 	            con.close();  
	 	             
			}catch(Exception ex){ex.printStackTrace();} 
			return status;
		}


		public static int updatedetails(add_details a) {
			// TODO Auto-generated method stub
			int status1=0;  
	        try{  
	            Connection con=newuserdao.getConnection();  
	            PreparedStatement ps=con.prepareStatement(  
	                         "update Add_details set phone_no=?,salary=?,city=?,state=?,country=?,department=? where id=?");  
	            ps.setDouble(1,a.getphone_no());
	            ps.setString(2,a.getsalary());
	            ps.setString(3,a.getcity());
	            ps.setString(4,a.getstate());  
	              
	            ps.setString(5,a.getcountry());
	            ps.setString(6,a.getdepartment());
	            ps.setInt(7,a.getId());  
	              
	            status1=ps.executeUpdate();  
	              
	            con.close();  
	        }catch(Exception ex){ex.printStackTrace();}  
	          
	        return status1;  

			
		}


		public static int Edit_Task(task t) {
			// TODO Auto-generated method stub
			int status2=0;
			try{
			 Connection con=newuserdao.getConnection();  
	            PreparedStatement ps=con.prepareStatement(  
	            		"update tasks set  task_name=?,resolving_time=?,status=? where task_id=?");
			       ps.setString(1,t.getTask_name());
			       ps.setString(2,t.getResolving_time());
			       ps.setString(3,t.getStatus());
			       ps.setInt(4,t.getTask_id());
			       status2=ps.executeUpdate();
			       con.close();
			   }catch(Exception ex){ex.printStackTrace();}  
	            return status2;
		}


		public static int deletetask(int Task_id) {
			// TODO Auto-generated method stub
			 int status=0;  
		        try{  
		            Connection con=newuserdao.getConnection();  
		            PreparedStatement ps=con.prepareStatement("delete from tasks where Task_id=?");  
		            ps.setInt(1,Task_id);  
		            status=ps.executeUpdate();  
		              
		            con.close();  
		        }catch(Exception e){e.printStackTrace();}  
		          
		        return status;  
		}
		public static int delete_extra_details(int id){
			int status1=0;
			try{
				    Connection con=newuserdao.getConnection();  
		            PreparedStatement ps=con.prepareStatement("delete from add_details where id=?");  
		            ps.setInt(1,id);  
		            status1=ps.executeUpdate();  
		              
				con.close();
			}catch(Exception e){e.printStackTrace();}
			return status1;
			
		}

		  
	    

}