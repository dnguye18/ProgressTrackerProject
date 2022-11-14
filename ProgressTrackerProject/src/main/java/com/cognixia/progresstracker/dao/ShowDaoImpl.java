package com.cognixia.progresstracker.dao;

import com.cognixia.progresstracker.connection.ConnManager;
import com.cognixia.progresstracker.entities.Show;
import com.cognixia.progresstracker.entities.Watchlist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ShowDaoImpl implements ShowDao {

    private Connection conn = ConnManager.getConnection();


    @Override
    public Show getShowById(int showId) {
        try {
            PreparedStatement pstmt = conn.prepareStatement("select * from shows where show_id = ?");
            pstmt.setInt(1, showId);

            ResultSet rs = pstmt.executeQuery();

            rs.next();


            int showid = rs.getInt("show_id");
            String showName = rs.getString("show_name");
            int totalEps = rs.getInt("total_eps");

            Show show = new Show(showid, showName, totalEps);
            return show;

        } catch (SQLException e) {
            System.out.println("Watchlist with id = " + showId + " not found.");
        }

        return null;
    }

    @Override
    public Show getShowByName(String name) {
        return null;
    }

    @Override
    public List<Show> getAllShows() {
        return null;
    }

    @Override
    public List<Show> searchShow(int showId) {
        return null;
    }

    @Override
    public Boolean addShow(Show show) {
        return null;
    }

    @Override
    public Boolean updateShow(Show show) {
        return null;
    }

    @Override
    public Boolean deleteShowById(int showId) {
        return null;
    }
}
