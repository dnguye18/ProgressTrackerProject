DROP database IF EXISTS ProgressTracker;

CREATE database ProgressTracker;

USE ProgressTracker;

CREATE TABLE IF NOT EXISTS user (
	user_id INT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(60) NOT NULL UNIQUE,
    password VARCHAR(225) NOT NULL,
    first_name VARCHAR(20) NOT NULL,
    last_name VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS shows (
	show_id INT AUTO_INCREMENT PRIMARY KEY,
    show_name VARCHAR(60) NOT NULL,
    total_eps INT NOT NULL
);

CREATE TABLE IF NOT EXISTS progress (
	progress_id INT PRIMARY KEY,
    progress_name VARCHAR(40) NOT NULL
);

CREATE TABLE IF NOT EXISTS watchlist (
	user_id INT NOT NULL,
    show_id INT NOT NULL,
    progress_id INT NOT NULL,
    eps_seen INT NOT NULL,
    PRIMARY KEY (user_id, show_id),
    FOREIGN KEY (user_id) REFERENCES user(user_id),
    FOREIGN KEY (show_id) REFERENCES shows(show_id),
    FOREIGN KEY (progress_id) REFERENCES progress(progress_id)
);