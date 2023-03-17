package com.procesos.concessionaire.service;

import com.procesos.concessionaire.model.User;
import com.procesos.concessionaire.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {

    private final IUserRepository userRepository;

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getOneUser(User user) {
        return userRepository.findById(user.getId()).orElseThrow( () -> new RuntimeException("User not found") );
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow( () -> new RuntimeException("User not found") );
    }

    @Override
    public void updateUser(User user) {
        User userRequest = userRepository.findById(user.getId()).orElse(null);
        if (userRequest == null) {
            throw new RuntimeException("User not found");
        }
        userRequest.setName( user.getName() );
        userRequest.setLastName( user.getLastName() );
        userRequest.setEmail( user.getEmail() );
        userRequest.setPassword( user.getPassword() );
        userRequest.setAddress( user.getAddress() );
        userRequest.setBirthday( user.getBirthday() );

        userRepository.save(user);
    }



}
