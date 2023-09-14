package com.unidt.exception;

/**
 * @author: shane
 * @date: 2023-09-14 11:20:59
 * @version: 1.0
 */
public class BaseException extends RuntimeException {

    private String code;

    public BaseException() {
    }

    public BaseException(String code, String message) {
        super(message);
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }
}
