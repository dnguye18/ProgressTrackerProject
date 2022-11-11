package com.cognixia.progresstracker.connection;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnManager {
    private static Connection connection = null;

    private static final String URL = "jdbc:mysql://localhost:3306/ProgressTracker?serverTimezone=America/Chicago&useSSL=false&allowPublicKeyRetrieval=true";

    private static final String USERNAME = "root";
    private static final String PASSWORD = "admin";

    private static void makeConnection() {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Connected");
        } catch (SQLException e) {
            System.out.println("Could not connect to db");
        }
    }

    public static Connection getConnection() {
        if (connection == null) {
            makeConnection();
        }
        return connection;
    }
}
