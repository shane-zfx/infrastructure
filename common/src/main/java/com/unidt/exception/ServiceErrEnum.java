package com.unidt.exception;

/**
 * @author: shane
 * @date: 2023-09-14 14:13:53
 * @version: 1.0
 */
public enum ServiceErrEnum implements BusinessExceptionAssert{

    /**
     * 500 - 600 业务异常
     */
    ERR_NOT_NULL("510","参数不能为空"),
    ERR_ILLEGAL_PARAM("511","参数异常");
    /**
     * 600 - 700 远程调用异常
     */
    private final String code;
    private final String message;

    ServiceErrEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
