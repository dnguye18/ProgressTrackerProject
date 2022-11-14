package com.cognixia.progresstracker.dao;

import com.cognixia.progresstracker.connection.ConnManager;
import com.cognixia.progresstracker.entities.Watchlist;

import java.sql.*;
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
            int progressid = rs.getInt("progress_id");

            Watchlist watchlist = new Watchlist(watchlistid, userid, showid, progressid);
            return watchlist;

        } catch (SQLException e) {
            System.out.println("Watchlist with id = " + watchlistId + " not found.");
        }

        return null;
    }

    @Override
    public List<Watchlist> getAllWatchlists() {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM watchlist");

            List<Watchlist> watchList = new ArrayList<Watchlist>();

            while(rs.next()) {
                int watchlistid = rs.getInt("watchlist_id");
                int userid = rs.getInt("user_id");
                int showid = rs.getInt("show_id");
                int progressid = rs.getInt("progress_id");

                Watchlist list = new Watchlist(watchlistid, userid, showid, progressid);
                watchList.add(list);
            }

            return watchList;

        } catch (SQLException e) {
            System.out.println("Could not retrieve watchlist from database");
        }

        return null;
    }

    @Override
    public List<Watchlist> searchWatchlist(int userId) {
        try {
            PreparedStatement pstmt = conn.prepareStatement("select * from watchlist where user_id = ?");
            pstmt.setInt(1, userId);

            ResultSet rs = pstmt.executeQuery();

            List<Watchlist> watchList = new ArrayList<Watchlist>();

            while(rs.next()) {
                int watchlistid = rs.getInt("watchlist_id");
                int userid = rs.getInt("user_id");
                int showid = rs.getInt("show_id");
                int progressid = rs.getInt("progress_id");

                Watchlist list = new Watchlist(watchlistid, userid, showid, progressid);
                watchList.add(list);
            }

            // ...and return that list once finished
            return watchList;

        } catch (SQLException e) {
            System.out.println("Could not retrieve user's watchlist from database");
        }

        return null;
    }

    @Override
    public Boolean addWatchlist(Watchlist watchlist) {
        try {
            PreparedStatement pstmt = conn.prepareStatement("INSERT into watchlist(user_id, show_id, progress_id) values(?, ?, ?)");
            pstmt.setInt(1, watchlist.getUserid());
            pstmt.setInt(2, watchlist.getShowid());
            pstmt.setInt(3, watchlist.getProgressid());

            int i = pstmt.executeUpdate();

            if(i > 0) {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public Watchlist getWatchlistByProgress(int progressId) {
        try {
            PreparedStatement pstmt = conn.prepareStatement("select * from watchlist where progress_id = ?");
            pstmt.setInt(1, progressId);

            ResultSet rs = pstmt.executeQuery();

            rs.next();


            int watchlistid = rs.getInt("watchlist_id");
            int userid = rs.getInt("user_id");
            int showid = rs.getInt("show_id");
            int progressid = rs.getInt("progress_id");

            Watchlist watchlist = new Watchlist(watchlistid, userid, showid, progressid);
            return watchlist;

        } catch (SQLException e) {
            System.out.println("Watchlist with id = " + progressId + " not found.");
        }

        return null;
    }

    @Override
    public Watchlist getWatchlistByUser(int userId) {
        try {
            PreparedStatement pstmt = conn.prepareStatement("select * from watchlist where watchlist_id = ?");
            pstmt.setInt(1, userId);

            ResultSet rs = pstmt.executeQuery();

            rs.next();


            int watchlistid = rs.getInt("watchlist_id");
            int userid = rs.getInt("user_id");
            int showid = rs.getInt("show_id");
            int progressid = rs.getInt("progress_id");

            Watchlist watchlist = new Watchlist(watchlistid, userid, showid, progressid);
            return watchlist;

        } catch (SQLException e) {
            System.out.println("Watchlist with id = " + userId + " not found.");
        }

        return null;
    }

    @Override
    public Boolean updateWatchlist(Watchlist watchlist) {
        try {
            PreparedStatement pstmt = conn.prepareStatement("UPDATE watchlist SET user_id = ?, show_id = ?, progress_id = ? WHERE watchlist_id = ?");
            pstmt.setInt(1, watchlist.getUserid());
            pstmt.setInt(2, watchlist.getShowid());
            pstmt.setInt(3, watchlist.getProgressid());

            int i = pstmt.executeUpdate();

            if(i > 0) {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public Boolean deleteWatchlistById(int watchlistId) {
        try {
            PreparedStatement pstmt = conn.prepareStatement("DELETE from watchlist WHERE watchlist_id = ?");
            pstmt.setInt(1, watchlistId);

            int i = pstmt.executeUpdate();

            if(i > 0) {
                return true;
            }

        } catch (SQLException e) {
            System.out.println("Department with id = " + watchlistId + " not found.");
        }

        return false;
    }
}
