package dev.ardijorganxhi.librarymanagementsystem.service;

import dev.ardijorganxhi.librarymanagementsystem.entity.User;
import dev.ardijorganxhi.librarymanagementsystem.exception.APIException;
import dev.ardijorganxhi.librarymanagementsystem.mapper.UserMapper;
import dev.ardijorganxhi.librarymanagementsystem.model.enums.ErrorEnum;
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


    public void register(RegisterRequest request) throws Exception{

        User user = userMapper.register(request);
        userRepository.save(user);
    }

    public String login(LoginRequest request) {

        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        } catch (BadCredentialsException e){
            throw new APIException(ErrorEnum.VALIDATION_ERROR);
        }
        User user = userRepository.findByEmail(request.getEmail()).orElseThrow();
        return tokenService.generateToken(user);
    }
}
