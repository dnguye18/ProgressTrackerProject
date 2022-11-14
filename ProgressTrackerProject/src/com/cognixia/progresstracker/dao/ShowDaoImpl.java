package com.cognixia.progresstracker.dao;

import com.cognixia.progresstracker.entities.Show;
import com.cognixia.progresstracker.connection.ConnManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ShowDaoImpl implements ShowDao {

    @Override
    public List<Show> searchShow(int showId) {
        return null;
    }


	private Connection conn = ConnManager.getConnection();

	@Override
	public void updateShow(Show s) {
		
	}

	

	@Override
	public Show getShowById(int s_id) {
		return null;
	}
	@Override
	public Show getShowByName(String show_name) {
		return null;
	}
	

	@Override
	public List<Show> getAllShows() {

		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM shows ");
			List<Show> ShowList = new ArrayList<Show>();

			while (rs.next()) {
				// ...iterate through to get column info...
				int id = rs.getInt("show_id");
				String name = rs.getString("show_name");
				int total_eps = rs.getInt("total_eps");

				// ...then add them to the created list...
				Show currentShow = new Show(id, name, total_eps);
				ShowList.add(currentShow);
			}
			
//			for(Show show : ShowList) {
//				System.out.println(show.getShow_name());
//			}
			
			// ...return list once finished
			return ShowList;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
	@Override
	public Show addShow(Show show) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void deleteShowById(int showId) {
		// TODO Auto-generated method stub
		
	}

}
