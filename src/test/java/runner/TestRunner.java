package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/homeLoanBorrowing",
        glue = {"stepDefinations"},
        plugin = {"pretty", "html:target/cucumber-reports"},
        monochrome = true,
        dryRun = false
)

public class TestRunner {
}
