package com.validator.algo;

import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
/**
 * Algo to check if password string is between 5-12 characters in length
 */
public class CorrectLengthValidatorAlgoImpl implements ValidatorAlgo {
    @Override
    public Boolean isValid(String passwordString) {
        String regexExpression = "^.{5,12}$";
        return Pattern.matches(regexExpression, passwordString);
    }

    @Override
    public String getErrorMessage() {
        return "Must be between 5-12 characters in length";
    }
}
