package com.procesos.concessionaire.service;

import com.procesos.concessionaire.model.User;
import com.procesos.concessionaire.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final IUserRepository userRepository;

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getOneUser(User user) {
        return userRepository.findById(user.getId()).orElseThrow(null);
    }

    public void updateUser(User user) {
        userRepository.save(user);
    }



}
