package com.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(plugin = {"usage","html:target/cucumber-reports/Cucumber.html"},
features = "src\\test\\resources\\com\\features\\LoginWithMultipleDataTable.feature",
glue = "com.stepDefinition"
//tags = "@validCredentials or @Smoke"
)
public class TestngRunner extends AbstractTestNGCucumberTests {
}
