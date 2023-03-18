package dev.ardijorganxhi.librarymanagementsystem.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class AuthenticationFailedException extends RuntimeException {

    private final HttpStatus httpStatus;

    public AuthenticationFailedException(HttpStatus httpStatus) {
        this.httpStatus = HttpStatus.UNAUTHORIZED;
    }
}
