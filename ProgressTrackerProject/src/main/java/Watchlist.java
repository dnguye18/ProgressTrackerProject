package main.java;

public class Watchlist {
	private int watchlist_id;
	private int user_id;
	private int show_id;
	
	public Watchlist(int watchlist_id, int user_id, int show_id) {
		super();
		this.watchlist_id = watchlist_id;
		this.user_id = user_id;
		this.show_id = show_id;
	}
	
	public int getWatchlist_id() {
		return watchlist_id;
	}
	public void setWatchlist_id(int watchlist_id) {
		this.watchlist_id = watchlist_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getShow_id() {
		return show_id;
	}
	public void setShow_id(int show_id) {
		this.show_id = show_id;
	}
	
}
