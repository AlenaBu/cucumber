package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/",
        //glue is where we can find the implementation for gherkin steps
        //here we provide the path of our steps package
        glue = "steps",
        //if we set dryRun to true, then no actual execution happens, it will quickly scan all gherkin steps if they have implementation or not
        dryRun = false,
        //it keeps console output for the cucumber test easily readable, it will remove all unreadable character
        monochrome = false,
        tags = "@datatable"

        //strict =true, it checks all the step definition

)


public class TestRunner {
}
