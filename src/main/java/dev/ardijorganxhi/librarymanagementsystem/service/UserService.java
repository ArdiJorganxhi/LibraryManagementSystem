package dev.ardijorganxhi.librarymanagementsystem.service;

import dev.ardijorganxhi.librarymanagementsystem.entity.Subscription;
import dev.ardijorganxhi.librarymanagementsystem.entity.User;
import dev.ardijorganxhi.librarymanagementsystem.mapper.SubscriptionMapper;
import dev.ardijorganxhi.librarymanagementsystem.mapper.UserMapper;
import dev.ardijorganxhi.librarymanagementsystem.model.dto.UserDto;
import dev.ardijorganxhi.librarymanagementsystem.model.request.RegisterSubscriptionRequest;
import dev.ardijorganxhi.librarymanagementsystem.repository.SubscriptionRepository;
import dev.ardijorganxhi.librarymanagementsystem.repository.UserRepository;
import lombok.RequiredArgsConstructor;
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
    public UserDto getUserById(Long id){
        return userMapper.toDto(userRepository.findById(id).orElseThrow());
    }
    public void deleteUser(Long id){
        User user = userRepository.findById(id).orElseThrow();
        userRepository.delete(user);
    }

    public Subscription registerMonthly(Long id, RegisterSubscriptionRequest request) throws Exception{
        User user = userRepository.findById(id).orElseThrow(() -> new Exception("User not found!"));
        Subscription subscription = subscriptionMapper.registerSubscriptionMonthly(user, request);
        user.setSubscribed(true);
        subscriptionRepository.save(subscription);
        return subscription;
    }

    public Subscription registerYearly(Long id, RegisterSubscriptionRequest request) throws Exception{
        User user = userRepository.findById(id).orElseThrow(() -> new Exception("User not found!"));
        Subscription subscription = subscriptionMapper.registerSubscriptionYearly(user, request);
        user.setSubscribed(true);
        subscriptionRepository.save(subscription);
        return subscription;
    }

    public void deleteSubscription(Long id) throws Exception{
        User user = userRepository.findById(id).orElseThrow(() -> new Exception("User not found!"));
        Subscription subscription = subscriptionRepository.findByUserId(id).orElseThrow(() -> new Exception("Subscription not found!"));
        subscriptionRepository.delete(subscription);
        user.setSubscribed(false);
    }
}
