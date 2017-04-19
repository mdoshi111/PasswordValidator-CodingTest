package com.validator.algo;

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
public class CorrectLengthValidatorAlgoImplTest {

    static Logger logger = LoggerFactory.getLogger(CorrectLengthValidatorAlgoImplTest.class);

    @Autowired CorrectLengthValidatorAlgoImpl correctLengthValidatorAlgo;


    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void whenContextIsBootstrapped_thenNoExceptions() {
        assert true;
    }

    @Test
    public void isValidTest(){
        assert correctLengthValidatorAlgo.isValid("1a15a");
        assert correctLengthValidatorAlgo.isValid("1a15aw"); //6
        assert correctLengthValidatorAlgo.isValid("1a15aje");  //7
        assert correctLengthValidatorAlgo.isValid("1a151hed");
        assert correctLengthValidatorAlgo.isValid("1a15djwu1");
        assert correctLengthValidatorAlgo.isValid("1a15djwie0");
        assert correctLengthValidatorAlgo.isValid("1a15dhf2yw7");
        assert correctLengthValidatorAlgo.isValid("123456789012"); //12
    }
    @Test
    public void inValidIfLessThanFive(){
        assert !correctLengthValidatorAlgo.isValid("1");
        assert !correctLengthValidatorAlgo.isValid("1a");
        assert !correctLengthValidatorAlgo.isValid("aa1");
        assert !correctLengthValidatorAlgo.isValid("a1a1");
    }
    @Test
    public void inValidIfMoreThanTwelve(){
        assert !correctLengthValidatorAlgo.isValid("1234567890121");
    }

    @Test
    public void testErrorMessage(){
        assert correctLengthValidatorAlgo.getErrorMessage() != null;
    }
}
