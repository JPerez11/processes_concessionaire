package com.procesos.concessionaire.repository;

import com.procesos.concessionaire.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Long> {

    User findUserById(Long id);

    User findUserByEmailAndPassword(String email, String password);

}
