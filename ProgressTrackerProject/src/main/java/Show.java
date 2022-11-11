package main.java;

public class Show {
	private int show_id;
	private String show_name;
	private int total_eps;
	public Show(int show_id, String show_name, int total_eps) {
		super();
		this.show_id = show_id;
		this.show_name = show_name;
		this.total_eps = total_eps;
	}
	public int getShow_id() {
		return show_id;
	}
	public void setShow_id(int show_id) {
		this.show_id = show_id;
	}
	public String getShow_name() {
		return show_name;
	}
	public void setShow_name(String show_name) {
		this.show_name = show_name;
	}
	public int getTotal_eps() {
		return total_eps;
	}
	public void setTotal_eps(int total_eps) {
		this.total_eps = total_eps;
	}
	
	
}
