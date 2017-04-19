package com.validator.service;

import com.validator.algo.AlphaNumericValidatorAlgoImpl;
import com.validator.algo.CorrectLengthValidatorAlgoImpl;
import com.validator.algo.SequenceValidatorAlgoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ValidatorServiceConfig {

    @Autowired AlphaNumericValidatorAlgoImpl alphaNumericValidatorAlgoImpl;
    @Autowired CorrectLengthValidatorAlgoImpl correctLengthValidatorAlgo;
    @Autowired SequenceValidatorAlgoImpl sequenceValidatorAlgo;

    @Bean
    public ValidatorService validatorService(){
        return new ValidatorServiceImpl(alphaNumericValidatorAlgoImpl, correctLengthValidatorAlgo, sequenceValidatorAlgo);
    }
}
