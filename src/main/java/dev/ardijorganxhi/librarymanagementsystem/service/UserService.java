package dev.ardijorganxhi.librarymanagementsystem.service;

import dev.ardijorganxhi.librarymanagementsystem.entity.Subscription;
import dev.ardijorganxhi.librarymanagementsystem.entity.User;
import dev.ardijorganxhi.librarymanagementsystem.mapper.SubscriptionMapper;
import dev.ardijorganxhi.librarymanagementsystem.mapper.UserMapper;
import dev.ardijorganxhi.librarymanagementsystem.model.dto.UserDto;
import dev.ardijorganxhi.librarymanagementsystem.model.request.RegisterSubscriptionRequest;
import dev.ardijorganxhi.librarymanagementsystem.model.response.UserResponse;
import dev.ardijorganxhi.librarymanagementsystem.repository.SubscriptionRepository;
import dev.ardijorganxhi.librarymanagementsystem.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.expression.ExpressionException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final SubscriptionMapper subscriptionMapper;
    private final SubscriptionRepository subscriptionRepository;

    public Optional<User> findByEmail(String email){
        return userRepository.findByEmail(email);

    }

    public List<UserDto> getUsers(){
        return userMapper.listToDto(userRepository.findAll());
    }

    public UserResponse findAllUsers(int pageNo, int pageSize, String sortBy, String sortDir){
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        Page<User> users = userRepository.findAll(pageable);

        return userMapper.toResponse(users);

    }
    public UserDto getUserById(Long id){
        return userMapper.toDto(userRepository.findById(id).orElseThrow());
    }
    public void deleteUser(Long id){
        User user = userRepository.findById(id).orElseThrow();
        userRepository.delete(user);
    }

}
