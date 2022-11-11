package com.cognixia.progresstracker.dao;

import com.cognixia.progresstracker.entities.User;

import java.util.List;

/**
 * @author Lewi
 */
public interface UserDao {
    User getUserById(int userId);
    User getUserByEmail(String email);
    List<User> getAllUsers();
    List<User> searchUser(int userId);
    User addUser(User user);
    void updateUser(User user);
    void deleteUserById(int userId);
}
