package com.cognixia.progresstracker.controller;

import com.cognixia.progresstracker.entities.User;
import com.cognixia.progresstracker.entities.Watchlist;

import java.util.List;

import com.cognixia.progresstracker.dao.WatchlistDaoImpl;
import com.cognixia.progresstracker.view.View;

/**
 * Controls main program
 * Lets users view, update and add to their watchlist
 */
public class MainController {
    private View view = new View();
    private UserController userCon = new UserController();
    private WatchlistDaoImpl dao = new WatchlistDaoImpl();

    private boolean running = true;
    private boolean internalLoopRun = true; 

	public void run() {
		while (running) {
			User currUser = userCon.login();

			if (currUser != null) {
				View.print("Greetings " + currUser.getFirstName());
				internalLoopRun = true;
				while (internalLoopRun) {
					int choice = view.menu();

					switch (choice) {

					case 1:
						viewWatchlist(currUser);
						break;
					case 2:
						updateWatchlist();
						break;
					case 0:
						exitInternal();
						userCon.clearUser();
						break;
					default:
						System.out.println();

					}
					System.out.println();
					System.out.println();
				}
			} else {
				exit();
			}

		}
	}

    private void viewWatchlist(User currUser) {
        List<Watchlist> watchlist = dao.getWatchlistByUser(currUser.getId());
        
        for (Watchlist entry: watchlist) {
        	View.print(entry.toString());
        }
    }

    private void updateWatchlist() {

    }

    private void exit() {
        View.print("Bye");
        running = false;
    }
    
    private void exitInternal() {
    	internalLoopRun = false;
    }
}
