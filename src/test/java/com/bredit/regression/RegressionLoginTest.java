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
import com.bredit.bean.LoginBean;
import com.bredit.factory.POMFactory;
import com.bredit.page.LoginPage;
import com.bredit.params.LoginParams;
import com.bredit.readexcel.ReadExcel;

/**
 * @author Bitan Sarkar
 * 
 *         Description: This class is for regression testing of Login Page of
 *         https://bredit.org in devices like: 1. Desktop 2. iPhone 3. iPad and
 *         browsers like: 1. chrome / 1 headless 2. firefox / 1 headless and we
 *         are filling the data from excel
 */
@RunWith(Parameterized.class)
public class RegressionLoginTest {
	private WebDriver driver;
	private POMFactory pom;
	private LoginBean loginBean;
	private String deviceName;
	private String browser;
	private String mode;

	public RegressionLoginTest(LoginParams params) {
		this.loginBean = params.getLoginBean();
		this.deviceName = params.getDeviceName();
		this.browser = params.getBrowserName();
		this.mode = params.getMode();
	}

	@Parameterized.Parameters
	public static List<Object> param() {
		List<Object> testList = new ArrayList<>();
		List<List<Object>> data = ReadExcel.getExcelContent(System.getProperty("user.dir") + "\\Testing.xlsx", 0);
		List<List<Object>> devices = ReadExcel.getExcelContent(System.getProperty("user.dir") + "\\Testing.xlsx", 2);
		List<List<Object>> browsers = ReadExcel.getExcelContent(System.getProperty("user.dir") + "\\Testing.xlsx", 3);

		for (List<Object> list : data) {
			for (List<Object> browser : browsers) {
				for (List<Object> dev : devices) {
					LoginBean login = new LoginBean();
					login.setEmail(list.get(0).toString());
					login.setPassword(list.get(1).toString());
					LoginParams p = new LoginParams(login, dev.get(0).toString(), browser.get(0).toString(), "head");
					testList.add(p);
				}
				LoginBean login = new LoginBean();
				login.setEmail(list.get(0).toString());
				login.setPassword(list.get(1).toString());
				LoginParams p = new LoginParams(login, "Desktop", browser.get(0).toString(), "headless");
				testList.add(p);
			}
		}
		return testList;
	}

	@Before
	public void getDriver() throws MalformedURLException {
		driver = TestBase.intialization(this.deviceName, this.browser, this.mode);
		driver.get("https://bredit.org/login");
		pom = new LoginPage(driver);
	}

	@Test
	public void regressionTest() {
		pom.fillAll(this.loginBean);
		pom.submitForm();
		capture(driver);
	}

	@After
	public void tearDown() {
		driver.quit();
	}
}
