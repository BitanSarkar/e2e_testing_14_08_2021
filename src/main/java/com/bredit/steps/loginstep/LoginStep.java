package com.bredit.steps.loginstep;

import org.openqa.selenium.WebDriver;

import com.bredit.base.TestBase;
import com.bredit.factory.POMFactory;
import com.bredit.page.LoginPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class LoginStep {
	private WebDriver driver;
	private POMFactory pom;
	private String deviceName;
	private String browser;
	private String mode;
	private String url;

	@Given("^the browser is \"([^\"]*)\"$")
	public void the_browser_is(String arg1) throws Throwable {
		this.browser = arg1;
	}

	@Given("^the device is \"([^\"]*)\"$")
	public void the_device_is(String arg1) throws Throwable {
		this.deviceName = arg1;
	}

	@Given("^the mode is \"([^\"]*)\"$")
	public void the_mode_is(String arg1) throws Throwable {
		this.mode = arg1;
	}

	@Given("^url is \"([^\"]*)\"$")
	public void url_is(String arg1) throws Throwable {
		this.url = arg1;
	}

	@Given("^page is loaded$")
	public void page_is_loaded() throws Throwable {
		this.driver = TestBase.intialization(this.deviceName, this.browser, this.mode);
		this.driver.get(this.url);
		this.pom = new LoginPage(this.driver);
	}

	@Given("^email is \"([^\"]*)\"$")
	public void email_is(String arg1) throws Throwable {
		this.pom.inputEmail(arg1);
	}

	@Given("^password is \"([^\"]*)\"$")
	public void password_is(String arg1) throws Throwable {
		this.pom.inputPassword(arg1);
	}

	@Given("^click on login button$")
	public void click_on_login_button() throws Throwable {
		this.pom.submitForm();
	}

	@Then("^check if user is loggedin$")
	public void check_if_user_is_loggedin() throws Throwable {
		// TO-DO when mongo is set up, possibly in next sprint
	}

	@Then("^close the browser$")
	public void close_the_browser() throws Throwable {
		this.driver.quit();
	}
}
