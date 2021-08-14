package com.bredit.testRunner;


import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features = { "src/main/resources/com/bredit/userstories/home.feature" },
		glue = {"com.bredit.steps.homestep" },
		plugin = {"com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/"
								+ "testreport" + ".html",
						"junit:target/cucumber-results.xml" },
		monochrome = true,
		tags = { "@Home" })

public class HomeBDDTest extends AbstractTestNGCucumberTests{

}
