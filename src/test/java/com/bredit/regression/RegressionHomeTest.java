package com.bredit.regression;

import static com.bredit.util.ScreenShotUtil.capture;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;

import com.bredit.base.TestBase;
import com.bredit.factory.POMFactory;
import com.bredit.page.HomePage;
import com.bredit.page.LoginPage;
import com.bredit.page.RegistrationPage;
import com.bredit.params.HomeParams;
import com.bredit.readexcel.ReadExcel;

/**
 * @author Bitan Sarkar
 * 
 *         Description: This class is for regression testing of Home Page of
 *         https://bredit.org in devices like: 1. Desktop 2. iPhone 3. iPad and
 *         browsers like: 1. chrome / 1 headless 2. firefox / 1 headless
 */

@RunWith(Parameterized.class)
public class RegressionHomeTest {
	private WebDriver driver;
	private POMFactory pom;
	private String deviceName;
	private String browser;
	private String mode;

	public RegressionHomeTest(HomeParams params) {
		this.deviceName = params.getDeviceName();
		this.browser = params.getBrowserName();
		this.mode = params.getMode();
	}

	@Parameterized.Parameters
	public static List<Object> param() {
		List<Object> testList = new ArrayList<>();
		List<List<Object>> devices = ReadExcel.getExcelContent(System.getProperty("user.dir") + "\\Testing.xlsx", 2);
		List<List<Object>> browsers = ReadExcel.getExcelContent(System.getProperty("user.dir") + "\\Testing.xlsx", 3);
		for (List<Object> browser : browsers) {
			for (List<Object> dev : devices) {
				HomeParams p = new HomeParams(dev.get(0).toString(), browser.get(0).toString(), "head");
				testList.add(p);
			}
			HomeParams p = new HomeParams("Desktop", browser.get(0).toString(), "headless");
			testList.add(p);
		}
		return testList;
	}

	@Before
	public void getDriver() throws MalformedURLException {
		driver = TestBase.intialization(this.deviceName, this.browser, this.mode);
		driver.get("https://bredit.org");
		pom = new HomePage(driver);
	}

	@Test
	public void regressionTestHome() throws InstantiationException {
		if (!this.deviceName.equalsIgnoreCase("desktop"))
			pom.clickOnNavRight();
		var ret0 = pom.clickOnHome();
		if (!(ret0 instanceof HomePage)) {
			throw new InstantiationException();
		}
		capture(driver);
	}

	@Test
	public void regressionTestLogin() throws InstantiationException {
		if (!this.deviceName.equalsIgnoreCase("desktop"))
			pom.clickOnNavRight();
		var ret0 = pom.clickOnLogin();
		if (!(ret0 instanceof LoginPage)) {
			throw new InstantiationException();
		}
		capture(driver);
	}

	@Test
	public void regressionTestRegister() throws InstantiationException {
		if (!this.deviceName.equalsIgnoreCase("desktop"))
			pom.clickOnNavRight();
		var ret0 = pom.clickOnRegistration();
		if (!(ret0 instanceof RegistrationPage)) {
			throw new InstantiationException();
		}
		capture(driver);
	}

	@After
	public void tearDown() {
		driver.quit();
	}
}
