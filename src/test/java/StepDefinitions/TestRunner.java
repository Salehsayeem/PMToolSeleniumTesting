package StepDefinitions;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features", glue= {"StepDefinitions"},
        plugin ={"pretty","json:target/JSONReports/report.json",
                "html:target\\HtmlReports\\report.html",
                "junit:target\\JunitReports\\report.xml"

        })


public class TestRunner {


}
