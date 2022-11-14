package com.cognixia.progresstracker.dao;

import com.cognixia.progresstracker.entities.Show;

import java.util.List;

public interface ShowDao {
    Show getShowById(int showId);
    Show getShowByName(String name);
    List<Show> getAllShows();
    List<Show> searchShow(int showId);
    Boolean addShow(Show show);
    Boolean updateShow(Show show);
    Boolean deleteShowById(int showId);

}
