package com.cognixia.progresstracker.controller;

import com.cognixia.progresstracker.entities.Watchlist;
import com.cognixia.progresstracker.dao.WatchlistDaoImpl;
import com.cognixia.progresstracker.view.View;

/**
 * Controls main program
 * Lets users view, update and add to their watchlist
 */
public class MainController {
    private View view = new View();
    private WatchlistDaoImpl dao = new WatchlistDaoImpl();

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
                    tests();
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

    private void tests() {
        Watchlist list = view.addWatchlist();
        if (dao.addWatchlist(list)) {
            System.out.println("Successfully added");
        } else {
            System.out.println("Error adding watchlist");
        }

    }
    private void viewWatchlist() {
        int watchlistid = view.getWatchlistId();

        Watchlist watchlist = dao.getWatchlistById(watchlistid);

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
