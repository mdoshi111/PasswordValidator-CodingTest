package com.validator.controller;

import com.validator.domain.Password;
import com.validator.service.ValidatorService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PasswordValidatorController {
    static Logger logger = LoggerFactory.getLogger(PasswordValidatorController.class);

    @Autowired
    private ValidatorService validatorService;
    @RequestMapping(value = "/validate/credentials",method = RequestMethod.POST, produces = {"application/json"})
    @ResponseBody
    public Password handlePasswordValidationPost(@RequestBody String username, String password) {
        return validatorService.validate(password);
    }


}