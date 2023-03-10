package dev.ardijorganxhi.librarymanagementsystem.model.request;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class RegisterRequest {

    private String name;
    private String surname;
    private String email;
    private String password;
}
