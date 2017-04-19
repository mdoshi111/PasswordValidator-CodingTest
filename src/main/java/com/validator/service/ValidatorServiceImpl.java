package com.validator.service;

import com.validator.algo.AlphaNumericValidatorAlgoImpl;
import com.validator.algo.CorrectLengthValidatorAlgoImpl;
import com.validator.algo.SequenceValidatorAlgoImpl;
import com.validator.algo.ValidatorAlgo;
import com.validator.domain.Password;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

public class ValidatorServiceImpl implements ValidatorService {

    private List<ValidatorAlgo> validationAlgos = new ArrayList<>();

    static Logger logger = LoggerFactory.getLogger(ValidatorServiceImpl.class);

    ValidatorServiceImpl(){}
    ValidatorServiceImpl(ValidatorAlgo ... args){
        for(ValidatorAlgo arg : args){
            validationAlgos.add(arg);
        }
    }

    @Override
    public Password validate(String text) {
        Boolean result = true;
        Password password = new Password(text);

        //If we don't do this and call validate mulitple times, the error list will duplicate
        password.getErrorsList().clear();

        for(ValidatorAlgo algo : validationAlgos){
            result = algo.isValid(password.getText());
            if(!result){
                password.appendError(algo.getErrorMessage());
            }
        }

        password.setValid(password.getErrorsList().size() > 0 ? false : true);
        return password;
    }
}
