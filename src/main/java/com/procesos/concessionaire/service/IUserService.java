package com.procesos.concessionaire.service;

import com.procesos.concessionaire.dto.UserRequestDto;
import com.procesos.concessionaire.model.User;

import java.util.List;

public interface IUserService {

    void saveUser(UserRequestDto user);

    List<User> getAllUsers();

    User getUserById(Long id);

    void updateUser(UserRequestDto user, Long id);

}
