package com.procesos.concessionaire.service;

import com.procesos.concessionaire.dto.UserRequestDto;
import com.procesos.concessionaire.exception.BadRequestException;
import com.procesos.concessionaire.exception.NoDataFoundException;
import com.procesos.concessionaire.exception.UserAlreadyExistsException;
import com.procesos.concessionaire.mapper.IUserRequestMapper;
import com.procesos.concessionaire.model.User;
import com.procesos.concessionaire.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {

    private final IUserRepository userRepository;
    private final IUserRequestMapper requestMapper;

    @Override
    public void saveUser(UserRequestDto user) {
        if (user == null) {
            throw new BadRequestException();
        }
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new UserAlreadyExistsException();
        }
        userRepository.save(requestMapper.toUser(user));
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
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
    public void updateUser(UserRequestDto user, Long id) {
        if (user == null) {
            throw new BadRequestException();
        }
        User userDb = userRepository.findUserById(id);
        if (userDb == null) {
            throw new NoDataFoundException();
        }
        userDb.setName( user.getName() );
        userDb.setLastName( user.getLastName() );
        userDb.setPassword( user.getPassword() );
        userDb.setAddress( user.getAddress() );
        userDb.setBirthday( user.getBirthday() );

        userRepository.save(userDb);
    }



}
