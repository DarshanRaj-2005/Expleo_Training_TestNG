package runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "target/failedrerun.txt",
		glue = "stepdefinitions",
				plugin = {"pretty", 
						"html:target/cucumber-report.html",
						"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
						"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
//						"rerun:target/failedrerun.txt"
						}
)
public class FailedRunner extends AbstractTestNGCucumberTests {
	@Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

}
