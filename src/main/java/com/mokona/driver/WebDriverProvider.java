package com.mokona.driver;

import javax.inject.Singleton;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.mokona.properties.MokonaProperties;

@Singleton
public class WebDriverProvider implements Provider<WebDriver> {

	private static final String CHROME_DRIVER_SYSTEM_PROPERTY = "webdriver.chrome.driver";

	@Inject
	private MokonaProperties mokonaProperties;

	private WebDriver driver;

	public WebDriver get() {
		if (driver == null && mokonaProperties.getChromeDriverPath() != null) {
			System.setProperty(CHROME_DRIVER_SYSTEM_PROPERTY, mokonaProperties.getChromeDriverPath());
			driver = new ChromeDriver();
		}
		return driver;
	}

}
