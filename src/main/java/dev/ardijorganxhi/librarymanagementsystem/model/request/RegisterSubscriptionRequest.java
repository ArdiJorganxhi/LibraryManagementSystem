package dev.ardijorganxhi.librarymanagementsystem.model.request;

import lombok.*;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterSubscriptionRequest {

    private LocalDate startDate;
}
