package com.bredit.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.bredit.factory.POMFactory;
import com.bredit.generics.GenericMethods;
import com.bredit.types.Locators;
import com.bredit.util.ReadPropertiesUtil;

/**
 * @author Bitan Sarkar
 * 
 *         Description: The Homepage class will have all the methods that needs
 *         to be in the home page. The methods should be in the POMFactory
 *         class.
 * 
 */
public class HomePage extends POMFactory {

	private GenericMethods genericMethods;
	private WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		genericMethods = new GenericMethods(driver);

	}

	@Override
	public HomePage clickOnHome() {
		WebElement home;
		String locator = ReadPropertiesUtil.getProperty("HOMEPAGE_HOME_BUTTON_CSS");
		home = genericMethods.getElement(locator, Locators.CSS);
		home.click();
		return new HomePage(driver);
	}

	@Override
	public LoginPage clickOnLogin() {
		WebElement login;
		String locator = ReadPropertiesUtil.getProperty("HOMEPAGE_LOGIN_BUTTON_CSS");
		login = genericMethods.getElement(locator, Locators.CSS);
		login.click();
		return new LoginPage(driver);
	}

	@Override
	public RegistrationPage clickOnRegistration() {
		WebElement registration;
		String locator = ReadPropertiesUtil.getProperty("HOMEPAGE_REGISTRATION_BUTTON_CSS");
		registration = genericMethods.getElement(locator, Locators.CSS);
		registration.click();
		return new RegistrationPage(driver);
	}

	@Override
	public void clickOnNavRight() {
		WebElement nav;
		String locator = ReadPropertiesUtil.getProperty("HOMEPAGE_NAV_RIGHT_BUTTON_CSS");
		nav = genericMethods.getElement(locator, Locators.CSS);
		nav.click();
	}
}
