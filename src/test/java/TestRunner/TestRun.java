package TestRunner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/main/resources/Features",
        glue={"StepsDefinitions"},
        tags = "@Regression",
        plugin = {"pretty",
                "html:target/cucumber.html",
                "json:target/cucumber.json",
                "junit:target/cucumber.xml",
                "rerun:target/cucumber.txt"
        }
)
public class TestRun extends AbstractTestNGCucumberTests {
}
