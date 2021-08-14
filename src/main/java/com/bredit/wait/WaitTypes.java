package com.bredit.wait;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitTypes {
	private WebDriver driver;
	private WebDriverWait wait;

	public WaitTypes(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement presenceOfElementLocated(By locator, long timeout) {
		try {
			wait = new WebDriverWait(driver, timeout);
			return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public WebElement waitForElement(By locator, long timeout) {
		try {
			wait = new WebDriverWait(driver, timeout);
			return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public WebElement elementToBeClickable(By locator, long timeout) {
		try {
			wait = new WebDriverWait(driver, timeout);
			return wait.until(ExpectedConditions.elementToBeClickable(locator));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<WebElement> presenceOfElementsLocated(By locator, long timeout) {
		try {
			wait = new WebDriverWait(driver, timeout);
			return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
