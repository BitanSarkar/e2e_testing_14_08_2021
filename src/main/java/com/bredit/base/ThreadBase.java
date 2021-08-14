package com.bredit.base;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadBase implements Runnable {

	private WebDriver webDriver;

	public ThreadBase(WebDriver driver) {
		this.webDriver = driver;
	}

	public static void main(String[] args) throws MalformedURLException {

		WebDriver driver = TestBase.intialization("Desktop", "chrome", "headful");
		Thread t1 = new Thread(new ThreadBase(driver));
		Thread t2 = new Thread(new ThreadBase(driver));
		t1.start();
		t2.start();
	}

	@Override
	public void run() {
		// driver = TestBase.intialization("Desktop", "chrome", "headful");
		webDriver.get("https://bredit.org/login");
		log.info("Thread " + Thread.currentThread().getId() + " is running");
		webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		webDriver.quit();
		log.info("Thread " + Thread.currentThread().getId() + " is shut down");

	}

}
