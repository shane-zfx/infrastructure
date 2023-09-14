package com.unidt.exception;

/**
 * @author: shane
 * @date: 2023-09-14 11:38:16
 * @version: 1.0
 */
public interface BusinessExceptionAssert extends Assert, BaseExceptionEnum {
    @Override
    default BaseException newException() {
        return this.newException(this.getMessage());
    }

    @Override
    default BaseException newException(String prompt) {
        return new BusinessException(this.getCode(), prompt);
    }

    @Override
    default BaseException newException(String prompt, String internalErrMessage) {
        return new BusinessException(this.getCode(), prompt, internalErrMessage);
    }
}
