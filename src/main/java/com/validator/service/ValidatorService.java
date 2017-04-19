package com.validator.service;
import com.validator.domain.Password;

public interface ValidatorService {
    public Password validate(String text);
}
