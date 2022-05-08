package com.example.rpccore.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zhujun
 */
@Data
@Slf4j
@EqualsAndHashCode(callSuper = false)
public class CustomException extends RuntimeException {

    private String message;

    public CustomException() {
        super();
    }

    public CustomException(String message) {
        super(message);
        this.message = message;
    }
}
