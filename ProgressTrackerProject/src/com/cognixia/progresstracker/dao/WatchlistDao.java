package com.cognixia.progresstracker.dao;

import com.cognixia.progresstracker.entities.Watchlist;

import java.util.List;

public interface WatchlistDao {
    Watchlist getWatchlistById(int watchlistId);
    Watchlist getWatchlistByProgress(int progressId);
    List<Watchlist> getAllWatchlists();
    List<Watchlist> getWatchlistByUserId(int userId);
    Boolean addWatchlist(Watchlist watchlist);
    Boolean updateWatchlist(Watchlist watchlist);
    Boolean deleteWatchlistById(int watchlistId);
}
