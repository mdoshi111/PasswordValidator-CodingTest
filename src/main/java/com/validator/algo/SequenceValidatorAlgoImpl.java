package com.validator.algo;

import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
/**
 * Algo to check that password string does not contain any sequence of characters immediately followed by
 * the same sequence
 */
public class SequenceValidatorAlgoImpl implements ValidatorAlgo{
    @Override
    public Boolean isValid(String passwordString) {
        String regexExpression = "([^.]{2,})\\1{1,}";

        Pattern p = Pattern.compile(regexExpression);
        Matcher m = p.matcher(passwordString);

        return !m.find();
    }

    @Override
    public String getErrorMessage() {
        return "Must not contain any sequence of characters immediately followed by the same sequence";
    }
}
