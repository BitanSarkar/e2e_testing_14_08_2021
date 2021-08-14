package com.bredit.testRunner;


import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = { "src/main/resources/com/bredit/userstories/login.feature" }, glue = {
		"com.bredit.steps.loginstep" }, plugin = {
				"com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/"
						+ "testreport" + ".html",
				"junit:target/cucumber-results.xml" }, monochrome = true, tags = { "@Login" })
public class LoginBDDTest extends AbstractTestNGCucumberTests{

}
