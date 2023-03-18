package dev.ardijorganxhi.librarymanagementsystem.exception;

import dev.ardijorganxhi.librarymanagementsystem.model.enums.ErrorEnum;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class APIException extends RuntimeException {

    private final ErrorEnum error;
    private final String[] args;

    public APIException(ErrorEnum error) {
        this.error = error;
        this.args = new String[0];
    }
    public APIException(ErrorEnum error, String... args) {
        this.error = error;
        this.args = args;
    }
}
