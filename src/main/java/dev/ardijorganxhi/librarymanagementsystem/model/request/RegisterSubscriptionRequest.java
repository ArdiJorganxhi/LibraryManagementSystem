package dev.ardijorganxhi.librarymanagementsystem.model.request;

import lombok.*;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterSubscriptionRequest {

    @NotBlank(message = "A date must be set!")
    private LocalDate startDate;
}
