package main.java;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDAOClass implements UserDAO {
	
	private Connection conn = ConnectionManager.getConnection();

	@Override
	public boolean addUser(User u) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User getUser(int u_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteUser(int u_id) {	
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateUser(User u) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public static void main(String[] args) {
		
	}
	
}
