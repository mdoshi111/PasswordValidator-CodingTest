package com.validator.service;

import com.validator.domain.Password;
import com.validator.password.init.Application;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class ValidatorServiceImplTest {

    static Logger logger = LoggerFactory.getLogger(ValidatorServiceImplTest.class);

    @Autowired ValidatorService validatorService;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void whenContextIsBootstrapped_thenNoExceptions() {
        assert true;
    }

    @Test
    public void isValidTest(){
        Password result = validatorService.validate("foo12");

        assert result.getValid();
        assert result.getErrorsList().size() == 0;
    }

    @Test
    public void invalidAllErrors(){
        Password result = validatorService.validate("fofo");

        assert !result.getValid();
        assert result.getErrorsList().size() == 3;
    }

    @Test
    public void justAlphaError(){
        Password result = validatorService.validate("foobar");

        assert !result.getValid();
        assert result.getErrorsList().size() == 1;
    }

    @Test
    public void justLengthError(){
        Password result = validatorService.validate("1a");

        assert !result.getValid();
        assert result.getErrorsList().size() == 1;
    }

    @Test
    public void justSequenceError(){
        Password result = validatorService.validate("1foo1foo");

        assert !result.getValid();
        assert result.getErrorsList().size() == 1;
    }


    @Test
    public void justTwoErrors(){
        Password result = validatorService.validate("1f1f");

        assert !result.getValid();
        assert result.getErrorsList().size() == 2;
    }


    @Test
    public void initilizedWithNoAlgos(){
        ValidatorServiceImpl serviceWithNoAlgos = new ValidatorServiceImpl();

        Password result = serviceWithNoAlgos.validate("");

        assert result.getValid();
        assert result.getErrorsList().size() == 0;
    }
}
