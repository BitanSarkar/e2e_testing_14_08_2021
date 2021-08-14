package com.bredit.steps.homestep;

import org.openqa.selenium.WebDriver;

import com.bredit.base.TestBase;
import com.bredit.factory.POMFactory;
import com.bredit.page.HomePage;
import com.bredit.page.LoginPage;
import com.bredit.page.RegistrationPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HomeStep {
	private WebDriver driver;
	private POMFactory pom;
	private String deviceName;
	private String browser;
	private String mode;
	private String url;

	@Given("^The home page is loaded$")
	public void the_home_page_is_loaded() throws Throwable {
		this.driver = TestBase.intialization(this.deviceName, this.browser, this.mode);
		this.driver.get(this.url);
		this.pom = new HomePage(this.driver);
		if (!this.deviceName.equalsIgnoreCase("desktop"))
			pom.clickOnNavRight();
	}

	@When("^I click the Home button$")
	public void i_click_the_Home_button() throws Throwable {
		pom = pom.clickOnHome();
	}

	@Then("^I will go to Home page$")
	public void i_will_go_to_Home_page() throws Throwable {
		if (!(pom instanceof HomePage)) {
			throw new InstantiationException();
		}
	}

	@When("^I click the Login button$")
	public void i_click_the_Login_button() throws Throwable {
		pom = pom.clickOnLogin();
	}

	@Then("^I will go to Login page$")
	public void i_will_go_to_Login_page() throws Throwable {
		if (!(pom instanceof LoginPage)) {
			throw new InstantiationException();
		}
	}

	@When("^I click the Registration button$")
	public void i_click_the_Registration_button() throws Throwable {
		pom = pom.clickOnRegistration();
	}

	@Then("^I will go to Registration page$")
	public void i_will_go_to_Registration_page() throws Throwable {
		if (!(pom instanceof RegistrationPage)) {
			throw new InstantiationException();
		}
	}

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

	@Then("^The close the browser$")
	public void the_close_the_browser() throws Throwable {
		this.driver.quit();
	}
}
