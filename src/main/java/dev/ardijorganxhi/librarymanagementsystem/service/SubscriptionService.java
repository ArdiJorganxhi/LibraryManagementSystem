package dev.ardijorganxhi.librarymanagementsystem.service;

import dev.ardijorganxhi.librarymanagementsystem.entity.Subscription;
import dev.ardijorganxhi.librarymanagementsystem.entity.User;
import dev.ardijorganxhi.librarymanagementsystem.mapper.SubscriptionMapper;
import dev.ardijorganxhi.librarymanagementsystem.model.request.RegisterSubscriptionRequest;
import dev.ardijorganxhi.librarymanagementsystem.repository.SubscriptionRepository;
import dev.ardijorganxhi.librarymanagementsystem.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;
    private final UserRepository userRepository;
    private final SubscriptionMapper subscriptionMapper;

    public Subscription registerMonthly(Long id, RegisterSubscriptionRequest request) throws Exception{
        User user = userRepository.findById(id).orElseThrow(() -> new Exception("User not found!"));
        Subscription subscription = subscriptionMapper.registerSubscriptionMonthly(user, request);
        subscriptionRepository.save(subscription);
        return subscription;
    }

    public Subscription registerYearly(Long id, RegisterSubscriptionRequest request) throws Exception{
        User user = userRepository.findById(id).orElseThrow(() -> new Exception("User not found!"));
        Subscription subscription = subscriptionMapper.registerSubscriptionYearly(user, request);
        subscriptionRepository.save(subscription);
        return subscription;
    }

    public void deleteSubscription(Long id) throws Exception{
        Subscription subscription = subscriptionRepository.findByUserId(id).orElseThrow(() -> new Exception("Subscription not found!"));
        subscription.getUser().setSubscription(null);
        subscriptionRepository.delete(subscription);

    }


}
