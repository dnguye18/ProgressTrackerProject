package main.java;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ShowDAOClass implements ShowDAO {

	private Connection conn = ConnectionManager.getConnection();

	@Override
	public boolean addShow(String show_name, int eps) {

		try {
			// ... set up prepared statement to set show name and number of episodes... 
			PreparedStatement pstmt = conn
					.prepareStatement(""
					+ "INSERT INTO shows (show_id, show_name, total_eps) "
					+ "VALUES (NULL, ?, ?)");
			pstmt.setString(1, show_name);
			pstmt.setInt(2, eps);
			pstmt.executeUpdate();
			return true;

		} catch (SQLException e) {
			System.out.println("Unable to add " + show_name + " to database.");
			e.printStackTrace();
		} 
		return false;

	}

	@Override
	public boolean updateShow(Show s) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteShow(int s_id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Show getShow(int s_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Show> getAllShows() {

		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM shows ");
			List<Show> ShowList = new ArrayList<Show>();
			
			while(rs.next()) {
				// ...iterate through to get column info...
				int id = rs.getInt("show_id");
				String name = rs.getString("show_name");
				int total_eps = rs.getInt("total_eps");
				
				// ...then add them to the created list...
				Show currentShow = new Show(id, name, total_eps);
				ShowList.add(currentShow);
			}
			// ...return list once finished
			return ShowList;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

}
