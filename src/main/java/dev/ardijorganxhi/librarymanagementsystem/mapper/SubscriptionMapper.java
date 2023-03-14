package dev.ardijorganxhi.librarymanagementsystem.mapper;

import dev.ardijorganxhi.librarymanagementsystem.entity.Subscription;
import dev.ardijorganxhi.librarymanagementsystem.entity.User;
import dev.ardijorganxhi.librarymanagementsystem.model.enums.SubscriptionType;
import dev.ardijorganxhi.librarymanagementsystem.model.request.RegisterSubscriptionRequest;
import org.springframework.stereotype.Component;

@Component
public class SubscriptionMapper {


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
}
