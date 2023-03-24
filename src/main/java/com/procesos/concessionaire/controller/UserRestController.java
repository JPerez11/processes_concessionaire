package com.procesos.concessionaire.controller;

import com.procesos.concessionaire.message.MessageController;
import com.procesos.concessionaire.model.User;
import com.procesos.concessionaire.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserRestController {

    private final IUserService userService;


    @GetMapping("/")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PostMapping("/")
    public ResponseEntity<Map<String, String>> saveUser(@RequestBody User user) {
        userService.saveUser(user);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Collections.singletonMap("message", MessageController.USER_CREATED.getMessage()));
    }

    @GetMapping("/getById/")
    public ResponseEntity<User> getOneUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.getOneUser(user));
    }

    @PutMapping("/")
    public ResponseEntity<Map<String, String>> updateUser(@RequestBody User user) {
        userService.updateUser(user);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Collections.singletonMap("message", MessageController.USER_UPDATED.getMessage()));
    }

}
