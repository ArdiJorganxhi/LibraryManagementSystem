package dev.ardijorganxhi.librarymanagementsystem.mapper;

import dev.ardijorganxhi.librarymanagementsystem.entity.Subscription;
import dev.ardijorganxhi.librarymanagementsystem.entity.User;
import dev.ardijorganxhi.librarymanagementsystem.model.enums.SubscriptionType;
import dev.ardijorganxhi.librarymanagementsystem.model.request.RegisterSubscriptionRequest;
import org.springframework.stereotype.Component;

@Component
public class SubscriptionMapper {


    public Subscription registerSubscriptionMonthly(User user, RegisterSubscriptionRequest request){
        return Subscription.builder()
                .user(user)
                .subscriptionType(SubscriptionType.MONTHLY)
                .startDate(request.getStartDate())
                .endDate(request.getStartDate().plusDays(30))
                .build();
    }

    public Subscription registerSubscriptionYearly(User user, RegisterSubscriptionRequest request){
        return Subscription.builder()
                .user(user)
                .subscriptionType(SubscriptionType.YEARLY)
                .startDate(request.getStartDate())
                .endDate(request.getStartDate().plusDays(365))
                .build();
    }
}
