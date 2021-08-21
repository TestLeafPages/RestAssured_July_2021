package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/java/features/IncidentManagement.feature"},
				glue = {"steps","hooks"})
//				tags = "@smoke")
public class RunCucumber extends AbstractTestNGCucumberTests{

}
