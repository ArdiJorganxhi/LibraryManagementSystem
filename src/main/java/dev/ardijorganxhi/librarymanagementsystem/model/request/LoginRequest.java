package dev.ardijorganxhi.librarymanagementsystem.model.request;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class LoginRequest {

    private String email;
    private String password;
}
