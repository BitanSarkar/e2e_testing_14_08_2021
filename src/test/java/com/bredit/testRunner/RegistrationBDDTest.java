package com.bredit.testRunner;


import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = { "src/main/resources/com/bredit/userstories/registration.feature" }, glue = {
		"com.bredit.steps.registrationstep" }, plugin = {
				"com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/"
						+ "testreport" + ".html",
				"junit:target/cucumber-results.xml" }, monochrome = true, tags = { "@Registration" })

public class RegistrationBDDTest extends AbstractTestNGCucumberTests{

}
