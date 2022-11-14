package com.cognixia.progresstracker.dao;

import com.cognixia.progresstracker.entities.Show;

import java.util.List;

public interface ShowDao {
    Show getShowById(int showId);
    Show getShowByName(String name);
    List<Show> getAllShows();
    List<Show> searchShow(int showId);
    Show addShow(Show show);
    void updateShow(Show show);
    void deleteShowById(int showId);

}
