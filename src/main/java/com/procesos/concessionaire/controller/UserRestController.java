package com.procesos.concessionaire.controller;

import com.procesos.concessionaire.dto.UserRequestDto;
import com.procesos.concessionaire.utils.message.MessageController;
import com.procesos.concessionaire.model.User;
import com.procesos.concessionaire.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import static com.procesos.concessionaire.utils.message.Constants.MESSAGE;

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
    public ResponseEntity<Map<String, String>> saveUser(@RequestBody UserRequestDto userRequest) {
        userService.saveUser(userRequest);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Collections.singletonMap(MESSAGE, MessageController.USER_CREATED.getMessage()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, String>> updateUser(@RequestBody UserRequestDto userRequest, @PathVariable Long id) {
        userService.updateUser(userRequest, id);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Collections.singletonMap(MESSAGE, MessageController.USER_UPDATED.getMessage()));
    }

}
