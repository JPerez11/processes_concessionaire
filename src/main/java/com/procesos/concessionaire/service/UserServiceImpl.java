package com.procesos.concessionaire.service;

import com.procesos.concessionaire.exception.NoDataFoundException;
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
        User userDb = userRepository.findUserById(user.getId());
        if (userDb == null) {
            throw new NoDataFoundException();
        }
        return userDb;
    }

    @Override
    public User getUserById(Long id) {
        User userDb = userRepository.findUserById(id);
        if (userDb == null) {
            throw new NoDataFoundException();
        }
        return userDb;
    }

    @Override
    public void updateUser(User user, Long id) {
        User userDb = userRepository.findUserById(id);
        if (userDb == null) {
            throw new NoDataFoundException();
        }
        userDb.setName( user.getName() );
        userDb.setLastName( user.getLastName() );
        userDb.setEmail( user.getEmail() );
        userDb.setPassword( user.getPassword() );
        userDb.setAddress( user.getAddress() );
        userDb.setBirthday( user.getBirthday() );

        userRepository.save(userDb);
    }



}
