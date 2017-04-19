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

import java.util.regex.Matcher;
import java.util.regex.Pattern;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class SequenceValidatorAlgoImplTest {

    static Logger logger = LoggerFactory.getLogger(SequenceValidatorAlgoImplTest.class);

    @Autowired SequenceValidatorAlgoImpl sequenceValidatorAlgoImpl;


    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void whenContextIsBootstrapped_thenNoExceptions() {
        assert true;
    }

    @Test
    public void isValidTest(){
        assert sequenceValidatorAlgoImpl.isValid("foobarhellofoobar");
        assert sequenceValidatorAlgoImpl.isValid("foobar1foobar");
        assert sequenceValidatorAlgoImpl.isValid("afoobar2foobar1");
        assert sequenceValidatorAlgoImpl.isValid("aaabbbccc");
        assert sequenceValidatorAlgoImpl.isValid("aa1aa");
    }


    @Test
    public void invalid(){
        assert !sequenceValidatorAlgoImpl.isValid("!!!!");
        assert !sequenceValidatorAlgoImpl.isValid("foobarfoobar");
        logger.info("WHAT: {}",sequenceValidatorAlgoImpl.isValid("1foobarfoobar"));
        Pattern p = Pattern.compile("([^.]{2,})\\1{1,}");
        Matcher m = p.matcher("1foobarfoobar");

        logger.info("{}",m.find());
        assert !sequenceValidatorAlgoImpl.isValid("1foobarfoobar");
        assert !sequenceValidatorAlgoImpl.isValid("foobarfoobar1");
        assert !sequenceValidatorAlgoImpl.isValid("foofoo");
        assert !sequenceValidatorAlgoImpl.isValid("aaaa");
    }


    @Test
    public void testErrorMessage(){
        assert sequenceValidatorAlgoImpl.getErrorMessage() != null;
    }
}
