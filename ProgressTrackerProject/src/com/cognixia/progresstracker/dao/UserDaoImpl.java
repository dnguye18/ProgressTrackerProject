package com.cognixia.progresstracker.dao;

import com.cognixia.progresstracker.connection.ConnManager;
import com.cognixia.progresstracker.entities.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
            pstmt.setInt(1, email);

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
            System.out.println("User with email = " + email + " not found.");
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
                String email = rs.getInString("email");
                int password = rs.getInt("password");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");

                User list = new User(userid, email, password,firstName,lastName);
                userList.add(list);
            }

            // ...and return that list once finished
            return userList;

        } catch (SQLException e) {
            System.out.println("Could not retrieve user list from database");
        }
        return null;
    }

    @Override
    public List<User> searchUser(int userId) {
        try {
            PreparedStatement pstmt = conn.prepareStatement("select * from user where user_id = ?");
            pstmt.setInt(1, userId);

            ResultSet rs = pstmt.executeQuery();

            rs.next();

            List<User> user = new ArrayList<User>();

            while(rs.next()) {
                int userid = rs.getInt("user_id");
                String email = rs.getInString("email");
                int password = rs.getInt("password");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");

                User list = new User(userid, email, password,firstName,lastName);
                user.add(list);
            }

            // ...and return that list once finished
            return user;

        } catch (SQLException e) {
            System.out.println("Could not retrieve user's watchlist from database");
        }

        return null;
    }

    @Override
    public User addUser(User user) {
        return null;
    }

    @Override
    public void updateUser(User user) {
        try {
            PreparedStatement pstmt = conn.prepareStatement("UPDATE user SET email = ?, password = ?, first_name = ?, last_name = ? WHERE user_id = ?");
            pstmt.setInt(1, user.getEmail());
            pstmt.setInt(2, user.getPassword());
            pstmt.setInt(3, user.getFirstName());
            pstmt.setInt(4, user.getLastName());

            int i = pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUserById(int userId) {
        try {
            PreparedStatement pstmt = conn.prepareStatement("DELETE from user WHERE user_id = ?");
            pstmt.setInt(1, userId);

            int i = pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Department with id = " + userId + " not found.");
        }
    }

}
