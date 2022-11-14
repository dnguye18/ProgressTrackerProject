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

            rs.first();


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
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public List<User> searchUser(int userId) {
        return null;
    }

    @Override
    public User addUser(User user) {
        return null;
    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void deleteUserById(int userId) {

    }

}
