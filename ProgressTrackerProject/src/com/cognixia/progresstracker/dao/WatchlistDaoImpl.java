package com.cognixia.progresstracker.dao;

import com.cognixia.progresstracker.connection.ConnManager;
import com.cognixia.progresstracker.entities.Watchlist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
    
    public List<Watchlist> getWatchlistByUserId(int userId){
    	try {
            PreparedStatement pstmt = conn.prepareStatement("select * from watchlist where user_id = ?");
            pstmt.setInt(1, userId);

            ResultSet rs = pstmt.executeQuery();

            ArrayList<Watchlist> watchlist = new ArrayList<Watchlist>();
            
            while (rs.next()) {
            	watchlist.add(new Watchlist(rs.getInt(1),
            			rs.getInt(2),
            			rs.getInt(3)));
            }

            return watchlist;

        } catch (SQLException e) {
            System.out.println("Watchlist with id = " + userId + " not found.");
        }

        return null;
    }

    @Override
    public List<Watchlist> getAllWatchlists() {
        return null;
    }

    @Override
    public List<Watchlist> searchWatchlist(int watchlistId) {
        return null;
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
