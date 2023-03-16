package dev.ardijorganxhi.librarymanagementsystem.controller;


import dev.ardijorganxhi.librarymanagementsystem.entity.User;
import dev.ardijorganxhi.librarymanagementsystem.model.request.LoginRequest;
import dev.ardijorganxhi.librarymanagementsystem.model.request.RegisterRequest;
import dev.ardijorganxhi.librarymanagementsystem.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;


    @PostMapping("/register")
    public void register(@RequestBody RegisterRequest request) throws Exception{
        authService.register(request);
    }
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest request) throws Exception{
        return ResponseEntity.ok(authService.login(request));
    }
}
