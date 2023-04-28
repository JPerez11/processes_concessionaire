package com.procesos.concessionaire.service;

import com.procesos.concessionaire.dto.UserLogin;
import com.procesos.concessionaire.exception.NoDataFoundException;
import com.procesos.concessionaire.model.User;
import com.procesos.concessionaire.repository.IUserRepository;
import com.procesos.concessionaire.utils.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class LoginServiceImpl implements ILoginService {

    private final IUserRepository userRepository;
    private final JwtUtil jwtUtil;

    @Override
    public String login(UserLogin userLogin) {
        User userDb = userRepository.findUserByEmailAndPassword(
                userLogin.getEmail(), userLogin.getPassword());
        if (userDb == null) {
            throw new NoDataFoundException();
        }
        return jwtUtil.create(String.valueOf(
                userDb.getId()), userDb.getEmail());
    }
}
