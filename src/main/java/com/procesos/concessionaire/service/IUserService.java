package com.procesos.concessionaire.service;

import com.procesos.concessionaire.model.User;

import java.util.List;

public interface IUserService {

    void saveUser(User user);

    List<User> getAllUsers();

    User getOneUser(User user);

    User getUserById(Long id);

    void updateUser(User user);

}
