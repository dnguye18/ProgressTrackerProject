package com.cognixia.progresstracker.controller;

import com.cognixia.progresstracker.dao.UserDao;
import com.cognixia.progresstracker.dao.UserDaoImpl;
import com.cognixia.progresstracker.entities.User;
import com.cognixia.progresstracker.entities.Watchlist;
import com.cognixia.progresstracker.dao.WatchlistDaoImpl;
import com.cognixia.progresstracker.view.View;

/**
 * Controls main program
 * Lets users view, update and add to their watchlist
 */
public class MainController {
    private View view = new View();
    private WatchlistDaoImpl watchlistDao = new WatchlistDaoImpl();
    private UserDaoImpl userDao = new UserDaoImpl();

    boolean running = true;

    public void run() {


        while (running) {

            int choice = view.menu();

            switch (choice) {

                case 1:
                    viewWatchlist();
                    break;
                case 2:
                    updateWatchlist();
                    break;
                case 3:
                    addWatchlist();
                    break;
                case 4:
                    addUser();
                    break;
                case 5:
                    getUserbyId();
                    break;
                case 0:
                    exit();
                    break;
                default:
                    System.out.println();

            }
            System.out.println();
            System.out.println();
        }
    }

    private void addUser() {
        User user = view.addUser();
        if (userDao.addUser(user)) {
            System.out.println("Successfully added");
        } else {
            System.out.println("Failed to add new user");
        }
    }

    private void addWatchlist() {
        Watchlist list = view.addWatchlist();
        if (watchlistDao.addWatchlist(list)) {
            System.out.println("Successfully added");
        } else {
            System.out.println("Error adding watchlist");
        }
    }

    private void getUserbyId() {
        // get user by id test
        int userid = view.getUserId();
        User user = userDao.getUserById(userid);
        System.out.println("id: " + user.getId());
        System.out.println("email: " + user.getEmail());
        System.out.println("password: " + user.getPassword());

    }
    private void viewWatchlist() {
        int watchlistid = view.getWatchlistId();

        Watchlist watchlist = watchlistDao.getWatchlistById(watchlistid);

        if(watchlist != null) System.out.println(watchlist.getWatchlistid() + " is in the db.");

        else System.out.println(watchlistid + " Was not found.");
    }

    private void updateWatchlist() {

    }

    private void exit() {
        view.print("Bye");
        running = false;
    }
}