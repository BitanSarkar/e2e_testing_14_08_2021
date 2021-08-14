package com.bredit.generics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.bredit.types.Locators;

public class GenericMethods {
	WebDriver driver;

	public GenericMethods(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getElement(String locator, String type) {
		WebElement element = null;
		if (type.equalsIgnoreCase(Locators.ID)) {
			element = driver.findElement(By.id(locator));
		} else if (type.equalsIgnoreCase(Locators.CSS)) {
			element = driver.findElement(By.cssSelector(locator));
		} else if (type.equalsIgnoreCase(Locators.NAME)) {
			element = driver.findElement(By.name(locator));
		} else if (type.equalsIgnoreCase(Locators.XPATH)) {
			element = driver.findElement(By.xpath(locator));
		}
		return element;
	}

//All the Buttons
	public WebElement getClickable(String locator, String type) {
		WebElement element = null;
		if (type.equalsIgnoreCase(Locators.ID)) {
			element = driver.findElement(By.id(locator));
		} else if (type.equalsIgnoreCase(Locators.CSS)) {
			element = driver.findElement(By.cssSelector(locator));
		} else if (type.equalsIgnoreCase(Locators.NAME)) {
			element = driver.findElement(By.name(locator));
		} else if (type.equalsIgnoreCase(Locators.XPATH)) {
			element = driver.findElement(By.xpath(locator));
		}
		return element;

	}

	public List<WebElement> getElementsAsList(String locator, String type) {
		List<WebElement> elements = null;
		if (type.equalsIgnoreCase(Locators.ID)) {
			elements = driver.findElements(By.id(locator));
		} else if (type.equalsIgnoreCase(Locators.CSS)) {
			elements = driver.findElements(By.cssSelector(locator));
		} else if (type.equalsIgnoreCase(Locators.NAME)) {
			elements = driver.findElements(By.name(locator));
		} else if (type.equalsIgnoreCase(Locators.XPATH)) {
			elements = driver.findElements(By.xpath(locator));
		}
		return elements;

	}

	public boolean isElementFound(String locator, String type) {
		return getElementsAsList(locator, type).size() > 0;
	}

	public void clearSend(WebElement element, String value) {
		element.clear();
		element.sendKeys(value);
	}
}
