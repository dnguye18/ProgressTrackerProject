package com.cognixia.progresstracker.view;

import java.util.List;
import java.util.Scanner;

import com.cognixia.progresstracker.entities.Progress;
import com.cognixia.progresstracker.entities.Show;
import com.cognixia.progresstracker.entities.Watchlist;

public class View {
    private final static Scanner sc = new Scanner(System.in);

    public View() {

    }

    public int menu() {
        print("Main Menu");
        print("1. View Watchlist");
        print("2. Add new Watchlist");
        print("3. Update Watchlist");
        print("4. Delete Watchlist");
        print("0. Exit");

        return readInt("Please select from the above choices.", 0, 4);
    }
    
    public int loginMenu() {
    	print("1. Login as Existing User");
    	print("0. Exit");
    	
    	return readInt("Please select from the above choices.", 0, 1);
    }
    
    public Progress getProgressChoice() {
    	print("1. Not Started");
    	print("2. In Progress");
    	print("3. Completed");
    	return Progress.idName(readInt("What do you want to change the progress to?", 1, 3));
    }
    
    public Watchlist selectWatchlist(List<Watchlist> listWatch) {
    	int index = 0;
    	
    	for (Watchlist watchlist: listWatch) {
    		index++;
    		print(index + ". " + watchlist.toString());
    	}
    	
    	index = readInt("Select a watchlist", 1, index);
    	
    	return listWatch.get(index - 1);
    }
    
    public Show selectShow(List<Show> listShow) {
    	int index = 0;
    	
    	for (Show show: listShow) {
    		index++;
    		print(index + ". " + show.toString());
    	}
    	
    	index = readInt("Select a show", 1, index);
    	
    	return listShow.get(index - 1);
    }
    
    public String getEmail() {
    	return readString("Enter your email");
    }
    
    public String getPassword() {
    	return readString("Enter your password");

    }
    
    public static void print(String msg) {
        System.out.println(msg);
    }

    public static String readString(String msgPrompt) {
        System.out.println(msgPrompt);
        return sc.nextLine();
    }

    public static int readInt(String msgPrompt) {
        boolean invalidInput = true;
        int num = 0;
        while (invalidInput) {
            try {
                String stringValue = readString(msgPrompt);
                num = Integer.parseInt(stringValue);
                invalidInput = false;
            } catch (NumberFormatException e) {
                print("Input error. Please try again.");
            }
        }
        return num;
    }

    public static int readInt(String msgPrompt, int min, int max) {
        int result;
        do {
            result = readInt(msgPrompt);
        } while (result < min || result > max);

        return result;
    }
}
