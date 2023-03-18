package dev.ardijorganxhi.librarymanagementsystem.service;

import dev.ardijorganxhi.librarymanagementsystem.entity.Book;
import dev.ardijorganxhi.librarymanagementsystem.entity.Subscription;
import dev.ardijorganxhi.librarymanagementsystem.entity.User;
import dev.ardijorganxhi.librarymanagementsystem.exception.APIException;
import dev.ardijorganxhi.librarymanagementsystem.mapper.SubscriptionMapper;
import dev.ardijorganxhi.librarymanagementsystem.model.dto.SubscriptionDto;
import dev.ardijorganxhi.librarymanagementsystem.model.enums.ErrorEnum;
import dev.ardijorganxhi.librarymanagementsystem.model.request.RegisterSubscriptionRequest;
import dev.ardijorganxhi.librarymanagementsystem.model.response.BookResponse;
import dev.ardijorganxhi.librarymanagementsystem.model.response.SubscriptionResponse;
import dev.ardijorganxhi.librarymanagementsystem.repository.SubscriptionRepository;
import dev.ardijorganxhi.librarymanagementsystem.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;
    private final UserRepository userRepository;
    private final SubscriptionMapper subscriptionMapper;

    public SubscriptionResponse getAllSubscriptions(int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        Page<Subscription> books = subscriptionRepository.findAll(pageable);
        return subscriptionMapper.toResponse(books);
    }

    public SubscriptionDto registerMonthly(Long id, RegisterSubscriptionRequest request) {
        User user = userRepository.findById(id).orElseThrow(() -> new APIException(ErrorEnum.USER_NOT_REGISTERED));
        Subscription subscription = subscriptionMapper.registerSubscriptionMonthly(user, request);
        subscriptionRepository.save(subscription);
        return subscriptionMapper.toDto(subscription);
    }

    public SubscriptionDto registerYearly(Long id, RegisterSubscriptionRequest request) {
        User user = userRepository.findById(id).orElseThrow(() -> new APIException(ErrorEnum.USER_NOT_REGISTERED));
        Subscription subscription = subscriptionMapper.registerSubscriptionYearly(user, request);
        subscriptionRepository.save(subscription);
        return subscriptionMapper.toDto(subscription);
    }

    public void deleteSubscription(Long id) {
        Subscription subscription = subscriptionRepository.findByUserId(id).orElseThrow(() -> new APIException(ErrorEnum.SUBSCRIPTION_NOT_FOUND));
        subscription.getUser().setSubscription(null);
        subscriptionRepository.delete(subscription);

    }


}
