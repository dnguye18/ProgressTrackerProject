package com.cognixia.progresstracker.controller;

import com.cognixia.progresstracker.entities.Progress;
import com.cognixia.progresstracker.entities.Show;
import com.cognixia.progresstracker.entities.User;
import com.cognixia.progresstracker.entities.Watchlist;

import java.util.List;

import com.cognixia.progresstracker.dao.ShowDaoImpl;
import com.cognixia.progresstracker.dao.WatchlistDaoImpl;
import com.cognixia.progresstracker.view.View;

/**
 * Controls main program
 * Lets users view, update and add to their watchlist
 */
public class MainController {
    private View view = new View();
    private UserController userCon = new UserController();
    private WatchlistDaoImpl watchDao = new WatchlistDaoImpl();
    private ShowDaoImpl showDao = new ShowDaoImpl();

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
						addWatchlist(currUser);
						break;
					case 3:
						updateWatchlist(currUser);
						break;
					case 4:
						deleteWatchList(currUser);
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
		List<Watchlist> wl = watchDao.getWatchlistByUserId(currUser.getId());
		for (Watchlist entry: wl) {
			View.print(entry.toString());
		}
	}
    
    private void addWatchlist(User currUser) {
    	Show selected = view.selectShow(showDao.getAllShows());
    	watchDao.addWatchlist(new Watchlist(0, currUser.getId(), selected.getShowid(), Progress.NOT_STARTED.idValue()));

    }

    private void updateWatchlist(User currUser) {
    	Watchlist selected = view.selectWatchlist(watchDao.getWatchlistByUserId(currUser.getId()));
    	Progress progressChange = view.getProgressChoice();
    	watchDao.updateWatchlist(new Watchlist(selected.getWatchlistid(), currUser.getId(),
    			selected.getShowid(), progressChange.idValue()));
    }
    
    private void deleteWatchList(User currUser) {
    	Watchlist selected = view.selectWatchlist(watchDao.getWatchlistByUserId(currUser.getId()));
    	watchDao.deleteWatchlistById(selected.getWatchlistid());
    }

    private void exit() {
        View.print("Bye");
        running = false;
    }
    
    private void exitInternal() {
    	internalLoopRun = false;
    }
}
