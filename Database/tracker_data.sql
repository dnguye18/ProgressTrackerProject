USE progresstracker;

SELECT * FROM progress;
INSERT INTO progress VALUES (0, "not completed");
INSERT INTO progress VALUES (1, "in-progress");
INSERT INTO progress VALUES (2, "completed");

SELECT * FROM shows;
INSERT INTO shows VALUES (NULL, "test", 10);

SELECT * from user;
INSERT INTO user VALUES(NULL, "a@a.com", "1234", "billy", "bob");

SELECT * FROM watchlist;
INSERT INTO watchlist VALUES(1, 1, 1, 4);