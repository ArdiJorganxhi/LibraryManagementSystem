package dev.ardijorganxhi.librarymanagementsystem.service;

import dev.ardijorganxhi.librarymanagementsystem.entity.User;
import dev.ardijorganxhi.librarymanagementsystem.mapper.UserMapper;
import dev.ardijorganxhi.librarymanagementsystem.model.request.LoginRequest;
import dev.ardijorganxhi.librarymanagementsystem.model.request.RegisterRequest;
import dev.ardijorganxhi.librarymanagementsystem.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;


    public User register(RegisterRequest request){

        User user = userMapper.register(request);
        userRepository.save(user);
        return user;
    }

    public String login(LoginRequest request) throws Exception {

        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        } catch (BadCredentialsException e){
            throw new Exception("BadCredentials");
        }
        User user = userRepository.findByEmail(request.getEmail()).orElseThrow();
        String jwtToken = tokenService.generateToken(user);
        return jwtToken;
    }
}
