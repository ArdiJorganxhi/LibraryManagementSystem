package dev.ardijorganxhi.librarymanagementsystem.model.request;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class RegisterRequest {

    @NotBlank(message = "A name must be given!")
    private String name;
    @NotBlank(message = "A surname must be given!")
    private String surname;
    @NotBlank(message = "Please enter an email!")
    @Email(message = "It should be a valid email format!")
    private String email;
    @NotBlank(message = "A password must be provided!")
    private String password;
}
