package com.bredit.factory;

import com.bredit.bean.LoginBean;
import com.bredit.bean.RegistrationBean;
import com.bredit.page.HomePage;
import com.bredit.page.LoginPage;
import com.bredit.page.RegistrationPage;

/**
 * @author Bitan Sarkar
 * 
 *         Description: This is an abstract class for Page Object Management
 *         which contains all the methods that would be used by the Pages in
 *         com.bredit.page. Note: While adding a new Page add the abstract
 *         methods in this class
 * 
 */
public abstract class POMFactory {
	public HomePage clickOnHome() {
		return null;
	}

	public LoginPage clickOnLogin() {
		return null;
	}

	public RegistrationPage clickOnRegistration() {
		return null;
	}

	public void clickOnNavRight() {
	}

	public void inputFirstName(String firstName) {
	}

	public void inputLastName(String lastName) {
	}

	public void inputEmail(String email) {
	}

	public void inputPhone(String phone) {
	}

	public void inputDateOfBirth(String dob) {
	}

	public void inputGender(String gender) {
	}

	public void inputCardNumber(String cardNumber) {
	}

	public void inputExpiryMonth(String expiryMonth) {
	}

	public void inputExpiryYear(String expiryYear) {
	}

	public void inputNameOnCard(String nameOnCard) {
	}

	public void inputPassword(String password) {
	}

	public void inputConfirmPassword(String confirmPassword) {
	}

	public void submitForm() {
	}

	public void fillAll(LoginBean login) {
	}

	public void fillAll(RegistrationBean register) {
	}

}
