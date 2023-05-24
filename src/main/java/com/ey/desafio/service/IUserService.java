package com.ey.desafio.service;

import com.ey.desafio.model.User;
import java.util.List;

public interface IUserService {
    User createUser(User user) throws Exception;
    List<User> getAllUsers();
    User getUser(String email);
    boolean deleteUser(User user);
    boolean isAValidEmail(String emailAddress);
    boolean isAValidPassword(String password);
}
