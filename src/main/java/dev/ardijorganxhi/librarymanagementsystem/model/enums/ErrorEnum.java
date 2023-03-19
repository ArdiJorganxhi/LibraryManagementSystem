package dev.ardijorganxhi.librarymanagementsystem.model.enums;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
public enum ErrorEnum {

    UNEXPECTED_ERROR(500, HttpStatus.INTERNAL_SERVER_ERROR),
    VALIDATION_ERROR(400, HttpStatus.BAD_REQUEST),
    UNAUTHORIZED(401, HttpStatus.UNAUTHORIZED),
    EMAIL_ALREADY_EXIST(400, HttpStatus.BAD_REQUEST),
    USER_NOT_REGISTERED(500, HttpStatus.INTERNAL_SERVER_ERROR),
    BOOK_NOT_REGISTERED(500, HttpStatus.INTERNAL_SERVER_ERROR),
    BOOK_ALREADY_EXIST(400, HttpStatus.BAD_REQUEST),
    BOOK_OUT_OF_STOCK(500, HttpStatus.INTERNAL_SERVER_ERROR),
    SUBSCRIPTION_ALREADY_EXISTS(500, HttpStatus.INTERNAL_SERVER_ERROR),
    SUBSCRIPTION_NOT_FOUND(500, HttpStatus.INTERNAL_SERVER_ERROR),
    SUBSCRIPTION_IS_VALID(400, HttpStatus.INTERNAL_SERVER_ERROR),
    HALL_NOT_EMPTY(503, HttpStatus.SERVICE_UNAVAILABLE),
    HALL_NOT_FOUND(500, HttpStatus.INTERNAL_SERVER_ERROR);



    private final int code;
    private final HttpStatus status;
}
