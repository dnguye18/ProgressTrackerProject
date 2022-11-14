package com.cognixia.progresstracker.dao;

import com.cognixia.progresstracker.entities.Watchlist;

import java.util.List;

public interface WatchlistDao {
    Watchlist getWatchlistById(int watchlistId);
    public void getAllWatchlists();
    List<Watchlist> searchWatchlist(int watchlistId);
    Watchlist addWatchlist(Watchlist watchlist);
    void updateWatchlist(Watchlist watchlist);
    void deleteWatchlistById(int watchlistId);
}
