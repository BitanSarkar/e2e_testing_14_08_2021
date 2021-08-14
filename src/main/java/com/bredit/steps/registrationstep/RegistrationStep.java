package com.bredit.steps.registrationstep;

import org.openqa.selenium.WebDriver;

import com.bredit.base.TestBase;
import com.bredit.factory.POMFactory;
import com.bredit.page.RegistrationPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class RegistrationStep {
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

	@Given("^device is \"([^\"]*)\"$")
	public void device_is(String arg1) throws Throwable {
		this.deviceName = arg1;
	}

	@Given("^url is \"([^\"]*)\"$")
	public void url_is(String arg1) throws Throwable {
		this.url = arg1;
	}

	@Given("^the mode is \"([^\"]*)\"$")
	public void the_mode_is(String arg1) throws Throwable {
		this.mode = arg1;
	}

	@Given("^page is loaded$")
	public void page_is_loaded() throws Throwable {
		this.driver = TestBase.intialization(this.deviceName, this.browser, this.mode);
		this.driver.get(this.url);
		this.pom = new RegistrationPage(this.driver);
	}

	@Given("^firstName is \"([^\"]*)\"$")
	public void firstname_is(String arg1) throws Throwable {
		pom.inputFirstName(arg1);
	}

	@Given("^lastName is \"([^\"]*)\"$")
	public void lastname_is(String arg1) throws Throwable {
		pom.inputLastName(arg1);
	}

	@Given("^emails is \"([^\"]*)\"$")
	public void emails_is(String arg1) throws Throwable {
		pom.inputEmail(arg1);
	}

	@Given("^phone is \"([^\"]*)\"$")
	public void phone_is(String arg1) throws Throwable {
		pom.inputPhone(arg1);
	}

	@Given("^dob is \"([^\"]*)\"$")
	public void dob_is(String arg1) throws Throwable {
		pom.inputDateOfBirth(arg1);
	}

	@Given("^gender is \"([^\"]*)\"$")
	public void gender_is(String arg1) throws Throwable {
		pom.inputGender(arg1);
	}

	@Given("^cardNumber is \"([^\"]*)\"$")
	public void cardnumber_is(String arg1) throws Throwable {
		pom.inputCardNumber(arg1);
	}

	@Given("^expiryMonth is \"([^\"]*)\"$")
	public void expirymonth_is(String arg1) throws Throwable {
		pom.inputExpiryMonth(arg1);
	}

	@Given("^expiryYear is \"([^\"]*)\"$")
	public void expiryyear_is(String arg1) throws Throwable {
		pom.inputExpiryYear(arg1);
	}

	@Given("^nameOnCard is \"([^\"]*)\"$")
	public void nameoncard_is(String arg1) throws Throwable {
		pom.inputNameOnCard(arg1);
	}

	@Given("^password is \"([^\"]*)\"$")
	public void password_is(String arg1) throws Throwable {
		pom.inputPassword(arg1);
	}

	@Given("^confirmPassword is \"([^\"]*)\"$")
	public void confirmpassword_is(String arg1) throws Throwable {
		pom.inputConfirmPassword(arg1);
	}

	@Given("^click on submit button$")
	public void click_on_submit_button() throws Throwable {
		pom.submitForm();
	}

	@Then("^check if user is registered$")
	public void check_if_user_is_registered() throws Throwable {
		// TO-DO when mongo is set up, possibly in next sprint
	}

	@Then("^close the browser$")
	public void close_the_browser() throws Throwable {
		driver.quit();
	}
}
