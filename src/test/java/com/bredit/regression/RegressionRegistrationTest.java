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
import com.bredit.bean.RegistrationBean;
import com.bredit.factory.POMFactory;
import com.bredit.page.RegistrationPage;
import com.bredit.params.RegistrationParams;
import com.bredit.readexcel.ReadExcel;

/**
 * @author Bitan Sarkar
 * 
 *         Description: This class is for regression testing of Registration
 *         Page of https://bredit.org in devices like: 1. Desktop 2. iPhone 3.
 *         iPad and browsers like: 1. chrome / 1 headless 2. firefox / 1
 *         headless and we are filling the data from excel
 */
@RunWith(Parameterized.class)
public class RegressionRegistrationTest {
	private WebDriver driver;
	private POMFactory pom;
	private RegistrationBean registrationBean;
	private String deviceName;
	private String browser;
	private String mode;

	public RegressionRegistrationTest(RegistrationParams params) {
		this.registrationBean = params.getRegistrationBean();
		this.deviceName = params.getDeviceName();
		this.browser = params.getBrowserName();
		this.mode = params.getMode();
	}

	@Parameterized.Parameters
	public static List<RegistrationParams> param() {
		List<RegistrationParams> testList = new ArrayList<>();
		List<List<Object>> data = ReadExcel.getExcelContent(System.getProperty("user.dir") + "\\Testing.xlsx", 1);
		List<List<Object>> devices = ReadExcel.getExcelContent(System.getProperty("user.dir") + "\\Testing.xlsx", 2);
		List<List<Object>> browsers = ReadExcel.getExcelContent(System.getProperty("user.dir") + "\\Testing.xlsx", 3);
		for (List<Object> list : data) {
			for (List<Object> browser : browsers) {
				for (List<Object> dev : devices) {
					RegistrationBean register = new RegistrationBean();
					register.setFirstName(list.get(0).toString());
					register.setLastName(list.get(1).toString());
					register.setEmail(list.get(2).toString());
					register.setPhone(list.get(3).toString());
					register.setDob(list.get(4).toString());
					register.setGender(list.get(5).toString());
					register.setCardNumber(list.get(6).toString());
					register.setExpiryMonth(list.get(7).toString());
					register.setExpiryYear(list.get(8).toString());
					register.setNameOnCard(list.get(9).toString());
					register.setPassword(list.get(10).toString());
					register.setConfirmPassword(list.get(11).toString());
					RegistrationParams p = new RegistrationParams(register, dev.get(0).toString(),
							browser.get(0).toString(), "head");
					testList.add(p);
				}
				RegistrationBean register = new RegistrationBean();
				register.setFirstName(list.get(0).toString());
				register.setLastName(list.get(1).toString());
				register.setEmail(list.get(2).toString());
				register.setPhone(list.get(3).toString());
				register.setDob(list.get(4).toString());
				register.setGender(list.get(5).toString());
				register.setCardNumber(list.get(6).toString());
				register.setExpiryMonth(list.get(7).toString());
				register.setExpiryYear(list.get(8).toString());
				register.setNameOnCard(list.get(9).toString());
				register.setPassword(list.get(10).toString());
				register.setConfirmPassword(list.get(11).toString());
				RegistrationParams p = new RegistrationParams(register, "Desktop", browser.get(0).toString(),
						"headless");
				testList.add(p);
			}
		}
		return testList;
	}

	@Before
	public void getDriver() throws MalformedURLException {
		driver = TestBase.intialization(this.deviceName, this.browser, this.mode);
		driver.get("https://bredit.org/registration");
		pom = new RegistrationPage(driver);
	}

	@Test
	public void regressionTest() {
		pom.fillAll(this.registrationBean);
		pom.submitForm();
		capture(driver);
	}

	@After
	public void tearDown() {
		driver.quit();
	}
}
