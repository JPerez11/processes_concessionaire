package com.procesos.concessionaire.mapper;

import com.procesos.concessionaire.dto.UserRequestDto;
import com.procesos.concessionaire.model.User;

public interface IUserRequestMapper {

    User toUser(UserRequestDto userRequestDto);

}
