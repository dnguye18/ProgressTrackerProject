DROP database IF EXISTS ProgressTracker;

CREATE database ProgressTracker;

USE ProgressTracker;

-- Table for user accounts
CREATE TABLE IF NOT EXISTS user (
	user_id INT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(60) NOT NULL UNIQUE,
    password VARCHAR(225) NOT NULL,
    first_name VARCHAR(20) NOT NULL,
    last_name VARCHAR(50) NOT NULL
);

-- Table for list of shows
CREATE TABLE IF NOT EXISTS shows (
	show_id INT AUTO_INCREMENT PRIMARY KEY,
    show_name VARCHAR(60) NOT NULL,
    total_eps INT NOT NULL
);


-- Table for keeping track of what user has watched what show
CREATE TABLE IF NOT EXISTS watchlist (
	watchlist_id INT NOT NULL AUTO_INCREMENT,
	user_id INT NOT NULL,
    show_id INT NOT NULL,
    progress_id INT NOT NULL,
    PRIMARY KEY (watchlist_id),
    FOREIGN KEY (user_id) REFERENCES user(user_id),
    FOREIGN KEY (show_id) REFERENCES shows(show_id)
);