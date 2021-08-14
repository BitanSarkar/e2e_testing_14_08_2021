package com.bredit.page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.bredit.bean.RegistrationBean;
import com.bredit.factory.POMFactory;
import com.bredit.generics.GenericMethods;
import com.bredit.types.Locators;
import com.bredit.util.ReadPropertiesUtil;

/**
 * @author Bitan Sarkar
 * 
 *         Description: The Registration page class will have all the methods
 *         that needs to be in the home page. The methods should be in the
 *         POMFactory class.
 * 
 */
public class RegistrationPage extends POMFactory {
	private WebDriver driver;
	private GenericMethods generics;

	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
		generics = new GenericMethods(driver);
	}

	@Override
	public void inputFirstName(String firstName) {
		WebElement firstNameElement;
		firstNameElement = generics.getElement(ReadPropertiesUtil.getProperty("REGISTRATIONPAGE_FIRSTNAME_INPUT_ID"),
				Locators.ID);
		generics.clearSend(firstNameElement, firstName);
	}

	@Override
	public void inputLastName(String lastName) {
		WebElement lastNameElement;
		lastNameElement = generics.getElement(ReadPropertiesUtil.getProperty("REGISTRATIONPAGE_LASTNAME_INPUT_ID"),
				Locators.ID);
		generics.clearSend(lastNameElement, lastName);
	}

	@Override
	public void inputEmail(String email) {
		WebElement emailElement;
		emailElement = generics.getElement(ReadPropertiesUtil.getProperty("REGISTRATIONPAGE_EMAIL_INPUT_ID"),
				Locators.ID);
		generics.clearSend(emailElement, email);
	}

	@Override
	public void inputPhone(String phone) {
		WebElement phoneElement;
		phoneElement = generics.getElement(ReadPropertiesUtil.getProperty("REGISTRATIONPAGE_PHONE_INPUT_ID"),
				Locators.ID);
		generics.clearSend(phoneElement, phone);
	}

	@Override
	public void inputDateOfBirth(String dob) {
		WebElement dobElement;
		dobElement = generics.getElement(ReadPropertiesUtil.getProperty("REGISTRATIONPAGE_DATE_OF_BIRTH_INPUT_NAME"),
				Locators.NAME);
		generics.clearSend(dobElement, dob);
		dobElement.sendKeys(Keys.ENTER);
	}

	@Override
	public void inputGender(String gender) {
		WebElement genderElement;
		genderElement = generics.getElement(
				ReadPropertiesUtil.getProperty("REGISTRATIONPAGE_" + gender.trim().toUpperCase() + "_INPUT_CSS"),
				Locators.CSS);
		((JavascriptExecutor) driver).executeScript("arguments[0].checked = true;", genderElement);
	}

	@Override
	public void inputCardNumber(String cardNumber) {
		WebElement cardNumberElement;
		cardNumberElement = generics.getElement(ReadPropertiesUtil.getProperty("REGISTRATIONPAGE_CARDNUMBER_INPUT_ID"),
				Locators.ID);
		generics.clearSend(cardNumberElement, cardNumber);
	}

	@Override
	public void inputExpiryMonth(String expiryMonth) {
		WebElement expiryMonthElement, monthElement;
		expiryMonthElement = generics
				.getElement(ReadPropertiesUtil.getProperty("REGISTRATIONPAGE_EXPIRY_MONTH_INPUT_NAME"), Locators.NAME);
		expiryMonthElement.click();
		int month = (int) Double.parseDouble(expiryMonth);
		monthElement = generics.getElement("option[value=\"" + (month < 10 ? "0" : "") + month + "\"]", Locators.CSS);
		monthElement.click();
	}

	@Override
	public void inputExpiryYear(String expiryYear) {
		WebElement expiryYearElement, yearElement;
		expiryYearElement = generics
				.getElement(ReadPropertiesUtil.getProperty("REGISTRATIONPAGE_EXPIRY_YEAR_INPUT_NAME"), Locators.NAME);
		expiryYearElement.click();
		int year = (int) Double.parseDouble(expiryYear);
		yearElement = generics.getElement("option[value=\"" + (year < 10 ? "0" : "") + year + "\"]", Locators.CSS);
		yearElement.click();
	}

	@Override
	public void inputNameOnCard(String nameOnCard) {
		WebElement nameOnCardElement;
		nameOnCardElement = generics
				.getElement(ReadPropertiesUtil.getProperty("REGISTRATIONPAGE_NAME_ON_CARD_INPUT_ID"), Locators.ID);
		generics.clearSend(nameOnCardElement, nameOnCard);
	}

	@Override
	public void inputPassword(String password) {
		WebElement passwordElement;
		passwordElement = generics.getElement(ReadPropertiesUtil.getProperty("REGISTRATIONPAGE_PASSWORD_INPUT_ID"),
				Locators.ID);
		generics.clearSend(passwordElement, password);
	}

	@Override
	public void inputConfirmPassword(String confirmPassword) {
		WebElement confirmPasswordElement;
		confirmPasswordElement = generics
				.getElement(ReadPropertiesUtil.getProperty("REGISTRATIONPAGE_CONFIRM_PASSWORD_INPUT_ID"), Locators.ID);
		generics.clearSend(confirmPasswordElement, confirmPassword);
	}

	@Override
	public void submitForm() {
		WebElement submit;
		submit = generics.getClickable(ReadPropertiesUtil.getProperty("REGISTRATIONPAGE_SUBMIT_BUTTON_CSS"),
				Locators.CSS);
		submit.click();
	}

	@Override
	public void fillAll(RegistrationBean register) {
		inputFirstName(register.getFirstName());
		inputLastName(register.getLastName());
		inputEmail(register.getEmail());
		inputPhone(register.getPhone());
		inputDateOfBirth(register.getDob());
		inputGender(register.getGender());
		inputCardNumber(register.getCardNumber());
		inputExpiryMonth(register.getExpiryMonth());
		inputExpiryYear(register.getExpiryYear());
		inputNameOnCard(register.getNameOnCard());
		inputPassword(register.getPassword());
		inputConfirmPassword(register.getConfirmPassword());
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

}
