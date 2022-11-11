package main.java;

public interface  UserDAO {
	public boolean addUser(User u);
	public User getUser(int u_id);
	public boolean deleteUser(int u_id);
	public boolean updateUser(User u);
}
