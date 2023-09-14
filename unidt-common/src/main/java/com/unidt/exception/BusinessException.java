package com.unidt.exception;

/**
 * @author: shane
 * @date: 2023-09-14 14:29:42
 * @version: 1.0
 */
public class BusinessException extends BaseException {

    private String internalMessage;

    public BusinessException(String code, String message){
        super(code, message);
        this.internalMessage = message;
    }

    public BusinessException(String code, String message, String internalMessage) {
        super(code, message);
        this.internalMessage = internalMessage;
    }

    public String getInternalMessage(){
        return this.internalMessage;
    }
}
