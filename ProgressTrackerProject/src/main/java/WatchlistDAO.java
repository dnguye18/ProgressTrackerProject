package main.java;

public interface WatchlistDAO {
	public boolean addWatchlist(Watchlist w);
	public Watchlist getWatchlist(int w_id);
	public boolean deleteWatchlist(int w_id);
	public boolean updateWatchlist(Watchlist w);
}
