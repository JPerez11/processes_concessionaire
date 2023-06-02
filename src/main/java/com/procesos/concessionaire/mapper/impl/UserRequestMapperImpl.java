package com.procesos.concessionaire.mapper.impl;

import com.procesos.concessionaire.dto.UserRequestDto;
import com.procesos.concessionaire.mapper.IUserRequestMapper;
import com.procesos.concessionaire.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserRequestMapperImpl implements IUserRequestMapper {
    @Override
    public User toUser(UserRequestDto userRequestDto) {

        if (userRequestDto == null) {
            return null;
        }

        User user = new User();

        user.setName( userRequestDto.getName() );
        user.setLastName( userRequestDto.getLastName() );
        user.setEmail( userRequestDto.getEmail() );
        user.setPassword( userRequestDto.getPassword() );
        user.setAddress( userRequestDto.getAddress() );
        user.setBirthday(userRequestDto.getBirthday());

        return user;
    }
}
