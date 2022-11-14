package com.cognixia.progresstracker.dao;

import com.cognixia.progresstracker.entities.Watchlist;

import java.util.List;

public interface WatchlistDao {
    Watchlist getWatchlistById(int watchlistId);
    Watchlist getWatchlistByProgress(int progressId);
    Watchlist getWatchlistByUser(int userId);
    List<Watchlist> getAllWatchlists();
    List<Watchlist> searchWatchlist(int userId);
    Watchlist addWatchlist(Watchlist watchlist);
    void updateWatchlist(Watchlist watchlist);
    void deleteWatchlistById(int watchlistId);
}
