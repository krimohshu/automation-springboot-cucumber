package com.yogi.stepdef;


import com.yogi.TestApplicationContext;
import com.yogi.config.TestProperties;
import cucumber.api.Scenario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.ConfigFileApplicationContextInitializer;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

/**
 * Common methods for all step definitions
 */
@ActiveProfiles("dev")
@ContextConfiguration(classes = TestApplicationContext.class, initializers = { ConfigFileApplicationContextInitializer.class })
public abstract class AbstractStepDefinition {

    protected Scenario scenario;

   /* @Autowired
    public TestWorld testWorld;*/
    @Autowired
    public TestProperties properties;


}
