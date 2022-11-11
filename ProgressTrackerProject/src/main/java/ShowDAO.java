package main.java;

public interface ShowDAO {
	public boolean addShow(Show s);
	public boolean updateShow(Show s);
	public boolean deleteShow(int s_id);
	public Show getShow(int s_id);
}
