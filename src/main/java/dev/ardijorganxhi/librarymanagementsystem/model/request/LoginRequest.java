package dev.ardijorganxhi.librarymanagementsystem.model.request;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class LoginRequest {

    @NotBlank(message = "Please enter an email!")
    @Email(message = "It should be a valid email format!")
    private String email;
    @NotBlank(message = "A password must be provided!")
    private String password;
}
