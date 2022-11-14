package com.cognixia.progresstracker.dao;

import com.cognixia.progresstracker.connection.ConnManager;
import com.cognixia.progresstracker.entities.User;
import com.cognixia.progresstracker.entities.Watchlist;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Lewi
 */
public class UserDaoImpl implements UserDao {

    private Connection conn = ConnManager.getConnection();

    @Override
    public User getUserById(int userId) {
        try {
            PreparedStatement pstmt = conn.prepareStatement("select * from user where user_id = ?");
            pstmt.setInt(1, userId);

            ResultSet rs = pstmt.executeQuery();

            rs.next();


            int id = rs.getInt("user_id");
            String email = rs.getString("email");
            String password = rs.getString("password");
            String firstname = rs.getString("first_name");
            String lastname = rs.getString("last_name");

            User user = new User(id, email, password, firstname, lastname);
            return user;

        } catch (SQLException e) {
            System.out.println("User with id = " + userId + " not found.");
        }

        return null;
    }

    @Override
    public User getUserByEmail(String email) {
        try {
            PreparedStatement pstmt = conn.prepareStatement("select * from user where email = ?");
            pstmt.setString(1, email);

            ResultSet rs = pstmt.executeQuery();

            rs.first();


            int id = rs.getInt("user_id");
            email = rs.getString("email");
            String password = rs.getString("password");
            String firstname = rs.getString("first_name");
            String lastname = rs.getString("last_name");

            User user = new User(id, email, password, firstname, lastname);
            return user;

        } catch (SQLException e) {
            System.out.println("User with id = " + email + " not found.");
        }

        return null;
    }

    @Override
    public List<User> getAllUsers() {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM user");

            List<User> userList = new ArrayList<User>();

            while(rs.next()) {
                int userid = rs.getInt("user_id");
                String email = rs.getString("email");
                String password = rs.getString("password");
                String firstname = rs.getString("first_name");
                String lastname = rs.getString("last_name");

                User user = new User(userid, email, password, firstname, lastname);
                userList.add(user);
            }

            return userList;

        } catch (SQLException e) {
            System.out.println("Could not retrieve userlist from database");
        }

        return null;
    }

    @Override
    public List<User> searchUser(int userId) {
        try {
            PreparedStatement pstmt = conn.prepareStatement("select * from user where user_id = ?");
            pstmt.setInt(1, userId);

            ResultSet rs = pstmt.executeQuery();

            List<User> userList = new ArrayList<User>();

            while(rs.next()) {
                int userid = rs.getInt("user_id");
                String email = rs.getString("email");
                String password = rs.getString("password");
                String firstname = rs.getString("first_name");
                String lastname = rs.getString("last_name");

                User user = new User(userid, email, password, firstname, lastname);
                userList.add(user);
            }

            return userList;

        } catch (SQLException e) {
            System.out.println("Could not retrieve user's watchlist from database");
        }

        return null;
    }

    @Override
    public Boolean addUser(User user) {
        try {
            PreparedStatement pstmt = conn.prepareStatement("INSERT into user(email, password, first_name, last_name) values(?, ?, ?, ?)");
            pstmt.setString(1, user.getEmail());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getFirstName());
            pstmt.setString(4, user.getLastName());

            int i = pstmt.executeUpdate();

            if(i > 0) {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public Boolean updateUser(User user) {
        try {
            PreparedStatement pstmt = conn.prepareStatement("UPDATE user SET email = ?, password = ?, first_name = ?, last_name = ? WHERE user_id = ?");
            pstmt.setString(1, user.getEmail());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getFirstName());
            pstmt.setString(4, user.getLastName());

            int i = pstmt.executeUpdate();

            if(i > 0) {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public Boolean deleteUserById(int userId) {
        try {
            PreparedStatement pstmt = conn.prepareStatement("DELETE from user WHERE user_id = ?");
            pstmt.setInt(1, userId);

            int i = pstmt.executeUpdate();

            if(i > 0) {
                return true;
            }

        } catch (SQLException e) {
            System.out.println("Department with id = " + userId + " not found.");
        }

        return false;
    }

}
