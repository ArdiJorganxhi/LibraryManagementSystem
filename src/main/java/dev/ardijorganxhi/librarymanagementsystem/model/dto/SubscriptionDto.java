package dev.ardijorganxhi.librarymanagementsystem.model.dto;

import dev.ardijorganxhi.librarymanagementsystem.model.enums.SubscriptionType;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SubscriptionDto {

    private UserDto user;
    private SubscriptionType subscriptionType;
    private LocalDate startDate;
    private LocalDate endDate;

}
