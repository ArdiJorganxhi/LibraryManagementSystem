package dev.ardijorganxhi.librarymanagementsystem.mapper;

import dev.ardijorganxhi.librarymanagementsystem.entity.Subscription;
import dev.ardijorganxhi.librarymanagementsystem.entity.User;
import dev.ardijorganxhi.librarymanagementsystem.model.dto.SubscriptionDto;
import dev.ardijorganxhi.librarymanagementsystem.model.enums.SubscriptionType;
import dev.ardijorganxhi.librarymanagementsystem.model.request.RegisterSubscriptionRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class SubscriptionMapper {

    private final UserMapper userMapper;


    public Subscription registerSubscriptionMonthly(User user, RegisterSubscriptionRequest request){

        Subscription subscription = new Subscription();
        subscription.setUser(user);
        subscription.setSubscriptionType(SubscriptionType.MONTHLY);
        subscription.setStartDate(request.getStartDate());
        subscription.setEndDate(request.getStartDate().plusDays(30));
        user.setSubscription(subscription);
        return subscription;
    }

    public Subscription registerSubscriptionYearly(User user, RegisterSubscriptionRequest request){
        Subscription subscription = new Subscription();
        subscription.setUser(user);
        subscription.setSubscriptionType(SubscriptionType.YEARLY);
        subscription.setStartDate(request.getStartDate());
        subscription.setEndDate(request.getStartDate().plusDays(365));
        user.setSubscription(subscription);
        return subscription;
    }

    public SubscriptionDto toDto(Subscription subscription){
        return SubscriptionDto.builder()
                .user(userMapper.toDto(subscription.getUser()))
                .subscriptionType(subscription.getSubscriptionType())
                .startDate(subscription.getStartDate())
                .endDate(subscription.getEndDate())
                .build();
    }
    public List<SubscriptionDto> listToDto(List<Subscription> subscriptions){
        return subscriptions.stream().map(this::toDto).collect(Collectors.toList());
    }
}
