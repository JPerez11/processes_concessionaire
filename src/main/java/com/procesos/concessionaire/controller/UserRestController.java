package com.procesos.concessionaire.controller;

import com.procesos.concessionaire.model.User;
import com.procesos.concessionaire.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserRestController {

    private final UserServiceImpl userServiceImpl;


    @GetMapping("/")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userServiceImpl.getAllUsers());
    }

    @PostMapping("/")
    public ResponseEntity<Void> saveUser(@RequestBody User user) {
        userServiceImpl.saveUser(user);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/getById/")
    public ResponseEntity<User> getOneUser(@RequestBody User user) {
        return ResponseEntity.ok(userServiceImpl.getOneUser(user));
    }

    @PutMapping("/")
    public ResponseEntity<Void> updateUser(@RequestBody User user) {
        userServiceImpl.updateUser(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
