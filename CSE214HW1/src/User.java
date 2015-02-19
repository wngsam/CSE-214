//Sam Wang
//ID: 108107971
//Homework #1
//CSE214
//R04 Varun Agrawal

public class User {

	String username, password, email, fullName;
	
	public User(){
		
	}
	
	public User(String username, String password, String email, String fullName){
		this.username=username;
		this.password=password;
		this.email=email;
		this.fullName=fullName;
	}
	
	public void setUsername(String username){
		this.username=username;
	}
	public void setPassword(String password){
		this.password=password;
	}
	public void setEmail(String email){
		this.email=email;
	}
	public void setFullName(String fullName){
		this.fullName=fullName;
	}
	
	public String getUsername(){
		return username;
	}
	public String getPassword(){
		return password;
	}
	public String getEmail(){
		return email;
	}
	public String getFullName(){
		return fullName;
	}
	
	public String toString(){
		return username+"       "+password+"       "+fullName+"       "+email;
	}
}
