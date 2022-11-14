package com.cognixia.progresstracker.dao;

import com.cognixia.progresstracker.entities.Show;

import java.util.List;

public class ShowDaoImpl implements ShowDao {

//    @Override
//    public List<Show> searchShow(int showId) {
//        return null;
//    }


	private Connection conn = ConnectionManager.getConnection();

	@Override
	public boolean addShow(String show_name, int total_eps) {
		
		Scanner sc = new Scanner(System.in);
		
		if (sc.hasNextLine()) {
			show_name = sc.nextLine();
		} else {
			// TODO handle invalid show name
			sc.close();
		}
		
		if (sc.hasNextInt()) {
			total_eps = sc.nextInt();
		} else {
			// TODO handle invalid total episodes
			sc.close();
		}
		

		try {
			// ... set up prepared statement to set show name and number of episodes...
			PreparedStatement pstmt = conn.prepareStatement(
					"" + "INSERT INTO shows (show_id, show_name, total_eps) " + "VALUES (NULL, ?, ?)");
			pstmt.setString(1, show_name);
			pstmt.setInt(2, total_eps);
			if(pstmt.executeUpdate() > 0) {
				System.out.println("Sucessfully added new show to database.");
			}
			return true;

		} catch (SQLException e) {
			System.out.println("Unable to add " + show_name + " to database.");
			e.printStackTrace();
		}
		return false;

	}
public boolean addShow() {
		String show_name = null;
		int total_eps = 0;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a Show name");
		
		if (sc.hasNextLine()) {
			show_name = sc.nextLine();
		} else {
			// TODO handle invalid show name
			sc.close();
		}
		System.out.println("Enter number of episodes");
		if (sc.hasNextInt()) {
			total_eps = sc.nextInt();
		} else {
			// TODO handle invalid total episodes
			sc.close();
		}
		
		

		try {
			// ... set up prepared statement to set show name and number of episodes...
			PreparedStatement pstmt = conn.prepareStatement(
					"" + "INSERT INTO shows (show_id, show_name, total_eps) " + "VALUES (NULL, ?, ?)");
			pstmt.setString(1, show_name);
			pstmt.setInt(2, total_eps);
			if(pstmt.executeUpdate() > 0) {
				System.out.println("Sucessfully added new show to database.");
			}
			return true;

		} catch (SQLException e) {
			System.out.println("Unable to add " + show_name + " to database.");
			e.printStackTrace();
		}
		return false;

	}

	@Override
	public boolean updateShow(Show s) {
		// Get show id from object...
		int show_id = s.getShow_id();

		try {
			
			// ...set up scanner and local variables
			Scanner sc = new Scanner(System.in);
			String show_name = null;

			// ...prompt for show name
			System.out.println("Enter a replacement Show name");
			if (sc.hasNextLine()) {
				show_name = sc.nextLine();
			} else {
				// TODO handle invalid show name
				sc.close();
			}
			System.out.println("Enter replacement number of episodes");
			// ...and prompt for total episodes...
			int total_eps = 0;
			if (sc.hasNextInt()) {
				total_eps = sc.nextInt();
			} else {
				// TODO handle invalid total episodes
				sc.close();
			}

			// ... set up prepared statement to update show name and number of episodes...
			PreparedStatement pstmt = conn
					.prepareStatement("UPDATE shows SET show_name = ?, total_eps = ? WHERE show_id = ? ");
			pstmt.setString(1, show_name);
			pstmt.setInt(2, total_eps);
			pstmt.setInt(3, show_id);
			pstmt.executeUpdate();
			return true;

		} catch (SQLException e) {
			String show_name = s.getShow_name();
			System.out.println("Unable to add " + show_name + " to database.");
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteShow(int s_id) {
		try {
			Scanner sc = new Scanner(System.in);
			PreparedStatement pstmt = conn.prepareStatement(" DELETE FROM shows WHERE show_id = ? ");
			pstmt.setInt(1, s_id);
			if (pstmt.executeUpdate() > 0) {
				return true;
			} 

		} catch (Exception e) {
			System.out.println("Unable to delete " + s_id + " from database.");
			e.printStackTrace();
		}
		return false;

	}

	@Override
	public Show getShowById(int s_id) {
		int show_id = 0;
		String show_name = null;
		int total_eps = 0;
		
		try {
			Scanner sc = new Scanner(System.in);
			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM shows WHERE (show_id = ?) ");
			pstmt.setInt(1, s_id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				show_id = rs.getInt("show_id");
				show_name = rs.getString("show_name");
				total_eps = rs.getInt("total_eps");
				
				return new Show(show_id, show_name, total_eps);
			} 

		} catch (Exception e) {
			System.out.println("Unable to get " + s_id + " from database.");
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public Show getShowByName(String show_name) {
		int show_id = 0;
		String show_name = null;
		int total_eps = 0;
		
		try {
			Scanner sc = new Scanner(System.in);
			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM shows WHERE (show_name = ?) ");
			pstmt.setString(1, show_name);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				show_id = rs.getInt("show_id");
				show_name = rs.getString("show_name");
				total_eps = rs.getInt("total_eps");
				
				return new Show(show_id, show_name, total_eps);
			} 

		} catch (Exception e) {
			System.out.println("Unable to get " + show_name + " from database.");
			e.printStackTrace();
		}
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

}
