package com.cognixia.progresstracker.dao;

import com.cognixia.progresstracker.connection.ConnManager;
import com.cognixia.progresstracker.entities.Watchlist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class WatchlistDaoImpl implements WatchlistDao {

    private Connection conn = ConnManager.getConnection();

    @Override
    public Watchlist getWatchlistById(int watchlistId) {
        try {
            PreparedStatement pstmt = conn.prepareStatement("select * from watchlist where watchlist_id = ?");
            pstmt.setInt(1, watchlistId);

            ResultSet rs = pstmt.executeQuery();

            rs.next();


            int watchlistid = rs.getInt("watchlist_id");
            int userid = rs.getInt("user_id");
            int showid = rs.getInt("show_id");

            Watchlist watchlist = new Watchlist(watchlistid, userid, showid);
            return watchlist;

        } catch (SQLException e) {
            System.out.println("Watchlist with id = " + watchlistId + " not found.");
        }

        return null;
    }
	
    @Override
    public static void getAllWatchlists() {
        try {
	    PreparedStatement pstmt = conn.preparedStatment("SELECT * FROM watchlist");
            ResultSet rs = pstmt.executeQuery();
            System.out.println("--------------All Watch Lists--------------");
            while(rs.next()) {
				System.out.println("user id: "+rs.getString("user_id")+ " Show Id: "+rs.getString("show_id")+" Progress Id: "+rs.getString("progress_id")+" Episodes Seen: "+rs.getString("eps_seen"));
			}
            System.out.println("-------------------------------------------");
            rs.close();			
			pstmt.close();
		}catch(Exception e){
			e.printStackTrace();
		}
    }

    @Override
    public static void searchWatchlist(int watchlistId) {
        try{
	    	PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM watchlist WHERE email =?;");	
		pstmt.
	}catch(Exception e){
	e.printStackTrace();
	}	
    }

    @Override
    public Watchlist addWatchlist(Watchlist watchlist) {
        return null;
    }

    @Override
    public void updateWatchlist(Watchlist watchlist) {

    }

    @Override
    public void deleteWatchlistById(int watchlistId) {

    }
}
