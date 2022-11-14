package com.cognixia.progresstracker.controller;

import com.cognixia.progresstracker.dao.UserDaoImpl;
import com.cognixia.progresstracker.entities.User;
import com.cognixia.progresstracker.view.View;

/**
 * Controls user login and registration
 */
public class UserController {
	private View view = new View();
	
	private boolean running = true;
	private User user = null;
	
	public User login() {
		while (running) {
			int choices = view.loginMenu();

			switch (choices) {
			case 1:
				user = validateUser();
				if (user != null) {
					exit();
				}
				break;
			case 0:
				exit();
				break;
			}
		}
		return user;
	}
	
	private User validateUser() {
		UserDaoImpl userDao = new UserDaoImpl();
		String email = view.getEmail();
		User userDetails = userDao.getUserByEmail(email);
		
		if (userDetails != null) {
			String password = view.getPassword();
			if (userDetails.getPassword().equals(password)) {
				exit();
				return userDetails;
			} else {
				System.out.println("Incorrect Password");
			}
			
		} else {
			System.out.println("Email not found");
		}
		
		return null;
	}
	
	private void exit() {
		running = false;
	}
	
	public void clearUser() {
		user = null;
		running = true;
	}
}
