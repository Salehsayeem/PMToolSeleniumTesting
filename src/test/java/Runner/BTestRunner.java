package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/**
 * @author MFU
 * 1/7/2021
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/",
        glue = "com.parata.steps",
        monochrome = true,

        plugin = { "pretty", "html:target/cucumber/cucumber-prettyb.html",
                   "json:target/cucumber/cucumber_b.json",
                    "junit:target/cucumber/cucumber_b.xml"})


public class BTestRunner {


}

