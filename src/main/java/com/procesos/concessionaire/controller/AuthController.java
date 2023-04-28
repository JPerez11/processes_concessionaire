package com.procesos.concessionaire.controller;

import com.procesos.concessionaire.dto.UserLogin;
import com.procesos.concessionaire.service.ILoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

    private final ILoginService loginService;

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody UserLogin userLogin) {
        String token = loginService.login(userLogin);
        Map<String, String> response = new HashMap<>();
        response.put("message", token);

        return ResponseEntity.status(HttpStatus.OK)
                .body(response);
    }

}
