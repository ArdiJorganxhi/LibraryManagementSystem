package dev.ardijorganxhi.librarymanagementsystem.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import dev.ardijorganxhi.librarymanagementsystem.embedded.UserId;
import dev.ardijorganxhi.librarymanagementsystem.model.enums.SubscriptionType;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@IdClass(UserId.class)
public class Subscription {

    @Id
    private long userId;

    @Enumerated(EnumType.STRING)
    private SubscriptionType subscriptionType;

    @Column(nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @Column(nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;
}
