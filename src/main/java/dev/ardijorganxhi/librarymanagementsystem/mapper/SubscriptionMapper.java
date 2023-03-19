package dev.ardijorganxhi.librarymanagementsystem.mapper;

import dev.ardijorganxhi.librarymanagementsystem.entity.Book;
import dev.ardijorganxhi.librarymanagementsystem.entity.Subscription;
import dev.ardijorganxhi.librarymanagementsystem.entity.User;
import dev.ardijorganxhi.librarymanagementsystem.model.dto.SubscriptionDto;
import dev.ardijorganxhi.librarymanagementsystem.model.enums.SubscriptionType;
import dev.ardijorganxhi.librarymanagementsystem.model.request.RegisterSubscriptionRequest;
import dev.ardijorganxhi.librarymanagementsystem.model.response.BookResponse;
import dev.ardijorganxhi.librarymanagementsystem.model.response.SubscriptionResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
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

    public SubscriptionResponse toResponse(Page<Subscription> subscriptionPage){
        return SubscriptionResponse.builder()
                .content(listToDto(subscriptionPage.getContent()))
                .pageNo(subscriptionPage.getNumber())
                .pageSize(subscriptionPage.getSize())
                .totalPages(subscriptionPage.getTotalPages())
                .totalElements(subscriptionPage.getTotalElements())
                .last(subscriptionPage.isLast())
                .build();
    }
    public SubscriptionDto renewSubscriptionMonthly(Subscription subscription){
        subscription.setSubscriptionType(SubscriptionType.MONTHLY);
        subscription.setStartDate(LocalDate.now());
        subscription.setEndDate(LocalDate.now().plusDays(30));
        return toDto(subscription);
    }

    public SubscriptionDto renewSubscriptionYearly(Subscription subscription){
        subscription.setSubscriptionType(SubscriptionType.YEARLY);
        subscription.setStartDate(LocalDate.now());
        subscription.setEndDate(LocalDate.now().plusDays(365));
        return toDto(subscription);
    }
}
