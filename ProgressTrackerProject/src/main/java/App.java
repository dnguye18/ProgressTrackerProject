package main.java;

import java.util.List;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		ShowDAOClass showDao = new ShowDAOClass();
		
		// --Testing add show
//		showDao.addShow("Brothers in Crime", 11);

		// -- testing adding a show
		showDao.addShow();
		showDao.addShow();
		
		// --Testing retrieval of all shows...
		List<Show> ShowList = showDao.getAllShows();

		// ...printing all shows
		System.out.println("----- Printing all Shows -----");
		for (Show show : ShowList) {
			System.out.println(show.getShow_name());
		}

		// --Testing getting first and second shows
		Show firstShow = showDao.getShow(1);
		System.out.println("Retrieved show: " + firstShow.getShow_name());
		Show secondShow = showDao.getShow(2);
		System.out.println("Retrieved show: " + secondShow.getShow_name());

		// --Testing updating show
		showDao.updateShow(secondShow);

		// --Testing delete show
		showDao.deleteShow(2);
		
		// ...printing all shows
		System.out.println("----- Printing all Shows -----");
		for (Show show : ShowList) {
			System.out.println(show.getShow_name());
		}
		System.out.println("----- End of all Shows -----");
	}
}
