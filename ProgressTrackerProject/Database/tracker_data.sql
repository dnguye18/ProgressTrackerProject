USE progresstracker;

SELECT * FROM shows;
INSERT INTO shows VALUES (NULL, "SpongeBob SquarePants", 277);
INSERT INTO shows VALUES (NULL, "Family Guy", 394);
INSERT INTO shows VALUES (NULL, "The Simpsons", 733);
INSERT INTO shows VALUES (NULL, "Vikings", 89);
INSERT INTO shows VALUES (NULL, "House of the Dragon", 10);
INSERT INTO shows VALUES (NULL, "Rick and Morty", 51);
INSERT INTO shows VALUES (NULL, "Stranger Things", 34);
INSERT INTO shows VALUES (NULL, "Breaking Bad", 62);
INSERT INTO shows VALUES (NULL, "Dexter", 96);
INSERT INTO shows VALUES (NULL, "House of the Dragon", 10);

SELECT * FROM watchlist;
SELECT * FROM user;
SELECT * FROM shows;

INSERT INTO user VALUES (NULL, "test@test.com", "test", "billy", "bob");
INSERT INTO watchlist VALUES (NULL, 1, 1, 1);