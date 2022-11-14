package com.cognixia.progresstracker.view;

import com.cognixia.progresstracker.entities.User;
import com.cognixia.progresstracker.entities.Watchlist;

import java.util.Scanner;

public class View {
    private final static Scanner sc = new Scanner(System.in);

    public View() {

    }

    public int menu() {
        print("Main Menu");
        print("1. View Watchlist");
        print("2. Update Watchlist");
        print("3. Tests");
        print("0. Exit");

        return readInt("Please select from the above choices.", 0, 3);
    }

    public Watchlist addWatchlist() {
        int userid = readInt("Enter user id");
        int showid = readInt("Enter show id");
        int progressid = readInt("Enter progress id");

        Watchlist list = new Watchlist();
        list.setUserid(userid);
        list.setShowid(showid);
        list.setProgressid(progressid);
        return list;
    }

    public User addUser() {
        String email = readString("Enter email:");
        String password = readString("Enter password:");
        String fName = readString("Enter first name:");
        String lName = readString("Enter last name:");

        User user = new User(email, password, fName, lName);

        return user;
    }

    public int getWatchlistId() {
        return readInt("Please enter watchlist id");

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
