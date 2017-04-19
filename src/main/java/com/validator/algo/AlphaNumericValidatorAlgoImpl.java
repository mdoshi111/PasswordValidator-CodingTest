package com.validator.algo;

import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
/**
 * Algo to check if alpha-numeric (lowercase only), with at least 1 alpha & 1 numeric
 */
public class AlphaNumericValidatorAlgoImpl implements ValidatorAlgo {

    @Override
    public Boolean isValid(String passwordString) {
        String regexExpression = "^(?=.*[0-9])(?=.*[a-z])([a-z0-9]+)$";
        return Pattern.matches(regexExpression, passwordString);
    }

    @Override
    public String getErrorMessage() {
        return "Must be lowercase alpha-numeric with at least one of each";
    }
}
