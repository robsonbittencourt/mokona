package com.mokona.drive;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class Driver {

	public static WebDriver driver;

	public static WebDriver getDriver() {
		if (driver == null) {
			System.setProperty("webdriver.chrome.driver", "C:/Renner.Config/" + "chromedriver.exe");
			driver = new ChromeDriver();
		}

		return driver;
	}

	public void endsDriver() {
		driver.close();
		driver.quit();
	}

}
