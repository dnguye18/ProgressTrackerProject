package main.java;

import java.util.List;
import java.util.Scanner;

public class App {
	
	public static void main(String[] args) {
		ShowDAOClass a = new ShowDAOClass();
		
		
		// -- testing adding a show
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a show name to add");
		if(sc.hasNextLine()) {
			String s = sc.nextLine();
			try {
//				System.out.println(s);
				a.addShow(s, 10);
			} catch (Exception e){
				System.out.println("Unable to add Show");
			}
			
		}
		sc.close();
		
		
//		 -- testing retrieval of all shows -- 
		List<Show> b = a.getAllShows();
		for(Show i : b) {
		System.out.println(i.getShow_name());
		}
	
	}
}
