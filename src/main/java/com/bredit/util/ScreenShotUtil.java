package com.bredit.util;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

/**
 * @author Aarsh Verdhan
 * 
 *         Description: Using the method capture of this class screen shots
 *         would be taken. It will be stored in the local Screenshot directory
 *         and also would be uploaded to Amazon S3 bucket
 * 
 */
public class ScreenShotUtil {
	public static void capture(WebDriver driver) {
		ResourceBundle rb = ResourceBundle.getBundle("config");
		Date date = new Date();
		String path = System.getProperty("user.dir") + rb.getString("SCREENSHOT_PATH_LOCAL");
		try {
			String fileName = date.toString().replace(":", "_").replace(" ", "_") + ".png";
			File screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenShot, new File(path + fileName));
			// S3util.saveToS3(fileName); to be added once S3 bucket creds are given
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void capture(WebDriver driver, String fileName) {
		((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	}
}
