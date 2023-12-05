package runners;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@CucumberOptions(
        tags =" @Econsent",
        features = "src/test/resources/features",
        glue = "stepDefinitions",
        publish = true,
        plugin = {
                "pretty",
                "html:target/cucumber-report/report.html"},
        stepNotifications = true
      // , dryRun = true
)

@RunWith(Cucumber.class)
public class CucumberRunner {



}
