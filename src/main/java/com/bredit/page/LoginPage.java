package com.bredit.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.bredit.bean.LoginBean;
import com.bredit.factory.POMFactory;
import com.bredit.generics.GenericMethods;
import com.bredit.types.Locators;
import com.bredit.util.ReadPropertiesUtil;

/**
 * @author Bitan Sarkar
 * 
 *         Description: The Login page class will have all the methods that
 *         needs to be in the home page. The methods should be in the POMFactory
 *         class.
 * 
 */
public class LoginPage extends POMFactory {
	private WebDriver driver;
	private GenericMethods generic;

	public LoginPage(WebDriver driver) {
		this.setDriver(driver);
		generic = new GenericMethods(driver);
	}

	@Override
	public void inputEmail(String name) {
		WebElement userName;
		userName = generic.getElement(ReadPropertiesUtil.getProperty("LOGINPAGE_EMAIL_INPUT_ID"), Locators.ID);
		generic.clearSend(userName, name);
	}

	@Override
	public void inputPassword(String passkey) {
		WebElement password;
		password = generic.getElement(ReadPropertiesUtil.getProperty("LOGINPAGE_PASSWORD_INPUT_ID"), Locators.ID);
		generic.clearSend(password, passkey);
	}

	@Override
	public void submitForm() {
		WebElement submit;
		submit = generic.getClickable(ReadPropertiesUtil.getProperty("LOGINPAGE_LOGIN_BUTTON_CSS"), Locators.CSS);
		submit.click();
	}

	@Override
	public void fillAll(LoginBean login) {
		inputEmail(login.getEmail());
		inputPassword(login.getPassword());
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

}
