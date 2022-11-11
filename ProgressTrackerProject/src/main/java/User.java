package main.java;

public class User {
	private int user_id;
	private String email;
	private String password;
	private String first_name;
	private String last_name;
	public User(String last_name, String password, String email, String first_name, int user_id) {
		super();
		this.last_name = last_name;
		this.password = password;
		this.email = email;
		this.first_name = first_name;
		this.user_id = user_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	
	 
	
}
