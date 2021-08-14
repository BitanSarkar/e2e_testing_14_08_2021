package com.bredit.base;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
//import org.openqa.selenium.support.events.EventFiringWebDriver;
//import org.openqa.selenium.support.events.WebDriverEventListener;

import com.bredit.types.Browsers;
import com.bredit.types.Device;
import com.bredit.types.Mode;
import com.bredit.types.OptionArgument;

/**
 * @author Kanav, Aarsh, Prateek
 * 
 *         Description: This is the main class from where we return driver
 *         depending on the device name, browser and mode, for parallel testing
 * 
 */
public class TestBaseParallel {
	private WebDriver driver;

	private static ResourceBundle resourceBundle;

	static {
		resourceBundle = ResourceBundle.getBundle("config");
	}

	public WebDriver intialization(String deviceName, String browserName, String mode) throws MalformedURLException {
		String path;
		String url = resourceBundle.getString("SELENIUM_HUB_URL");

		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setPlatform(Platform.ANY);
		desiredCapabilities.setBrowserName(browserName);

		if (browserName.equalsIgnoreCase(Browsers.CHROME)) {
			path = resourceBundle.getString(Browsers.CHROME_PATH);
			System.setProperty(Browsers.CHROME_KEY, path);
			ChromeOptions options = new ChromeOptions();

			if (deviceName.equalsIgnoreCase(Device.DESKTOP))
				options.addArguments(OptionArgument.DESKTOP_WINDOW);
			else {
				Map<String, String> mobileEmulation = new HashMap<>();
				mobileEmulation.put("deviceName", deviceName);
				options.setExperimentalOption("mobileEmulation", mobileEmulation);

			}

			options.addArguments(OptionArgument.ENABLE_AUTOMATION);
			options.addArguments(OptionArgument.NO_SANDBOX);
			options.addArguments(OptionArgument.DISABLE_EXTENSTIONS);
			options.addArguments(OptionArgument.DNS_PREFETCH_DISABLE);
			options.addArguments(OptionArgument.DISABLE_GPU);
			options.setPageLoadStrategy(PageLoadStrategy.NORMAL);

			if (mode.equalsIgnoreCase(Mode.HEADLESS)) {
				options.addArguments("headless");
			}

			desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, options);
			driver = new RemoteWebDriver(new URL(url), desiredCapabilities);

		} else if (browserName.equalsIgnoreCase(Browsers.Firefox)) {
			path = resourceBundle.getString(Browsers.FIREFOX_PATH);
			System.setProperty(Browsers.FIREFOX_KEY, path);
			FirefoxOptions options = new FirefoxOptions();
			desiredCapabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options);
			driver = new RemoteWebDriver(new URL(url), desiredCapabilities);
			if (deviceName.equalsIgnoreCase(Device.DESKTOP))
				driver.manage().window().setSize(new Dimension(1920, 1080));
			else if (deviceName.equalsIgnoreCase(Device.IPAD)) {
				driver.manage().window().setSize(new Dimension(768, 1024));
			} else
				driver.manage().window().setSize(new Dimension(375, 667));

			if (mode.equalsIgnoreCase(Mode.HEADLESS)) {
				options.addArguments(OptionArgument.HEADLESS);
			}
		}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(resourceBundle.getString("IMPLICIT_WAIT")),
				TimeUnit.SECONDS);
		return driver;

	}

}
