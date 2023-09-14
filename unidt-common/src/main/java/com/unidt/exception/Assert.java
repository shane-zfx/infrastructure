package com.unidt.exception;

import com.google.common.base.Objects;
import com.google.common.base.Strings;

/**
 * @author: shane
 * @date: 2023-09-14 10:42:01
 * @version: 1.0
 */
public interface Assert {
    BaseException newException();
    BaseException newException(String prompt);
    BaseException newException(String prompt, String internalErrMessage);

    default void check(boolean expression) {
        if (!expression) {
            throw newException();
        }
    }

    default void check(boolean expression, String customPrompt) {
        check(expression, customPrompt, customPrompt);
    }

    default void check(boolean expression, String customPrompt, String internalErrMessage) {
        if (!expression) {
            throw newException(customPrompt, internalErrMessage);
        }
    }

    default void check(boolean expression, String promptTemplate, Object... args) {
        if (!expression) {
            String customPrompt = Strings.lenientFormat(promptTemplate, args);
            throw newException(customPrompt);
        }
    }
}
