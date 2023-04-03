package com.yogi.testrunner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:cucumber/"}
        ,dryRun = false
        ,glue = {"classpath:"}
      //  ,tags = "@dvlasearch"
        ,format = {"json:target/cucumber-report/com.sedex.spectrum.qatests.ui.SmokeATTest.json",
                "html:target/cucumber-report/com.sedex.spectrum.qatests.ui.SmokeATTest",
        "junit:target/cucumber-report/com.sedex.spectrum.qatests.ui.cucumber.xml"}
)
public class CucumberRunnerTest {
}
