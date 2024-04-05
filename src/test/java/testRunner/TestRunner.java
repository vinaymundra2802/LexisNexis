package testRunner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "C://LexisNexis//src//test//resources//Features//LexisNexis.feature",
        glue = "stepdefinitions")




public class TestRunner {
}
