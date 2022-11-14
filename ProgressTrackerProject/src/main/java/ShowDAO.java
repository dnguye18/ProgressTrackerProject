package main.java;

import java.util.List;

public interface ShowDAO {
	public boolean addShow(String s, int eps);
	public boolean updateShow(Show s);
	public boolean deleteShow(int s_id);
	public Show getShow(int s_id);
	public List <Show> getAllShows();
}
