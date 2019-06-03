package com.crudapp.bean;

public class User {
	public int User_id,age;  
	public String name,password,email,gender,country;  
	
	public int getId() {  
	    return User_id;  
	}  
	public void setId(int User_id) {  
	    this.User_id = User_id;  
	}  
	public String getname() {  
	    return name;  
	}  
	public void setname(String name) {  
	    this.name = name;  
	}  
	  
	public String getPassword() {  
	    return password;  
	}  
	public void setPassword(String password) {  
	    this.password = password;  
	}  
	public String getEmail() {  
	    return email;  
	}  
	public void setEmail(String email) {  
	    this.email = email;  
	} 
	public String getgender() {
		return gender;
	}
	public void setgender(String gender){
		this.gender=gender;
	}
	public int getAge(){
		return age;
		}
	public void setAge(int age){
			this.age= age;
	}
	public String getcountry() {  
	    
		return country;  
	}  
	public void setcountry(String country) {  
	    this.country = country;  
	}
	  

}
