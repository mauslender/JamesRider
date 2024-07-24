package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/resources/features",
        glue = "stepdefinitions",
        plugin = { "pretty", "html:target/cucumber-reports" },
        monochrome = true
)
public class TestRunner {
    @BeforeClass
    public static void setUp() {

    }
}

