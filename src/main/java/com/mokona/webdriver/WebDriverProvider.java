package com.mokona.webdriver;

import javax.inject.Singleton;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.name.Named;
import com.mokona.exception.MokonaException;

@Singleton
public class WebDriverProvider implements Provider<WebDriver> {

    private WebDriver driver;
    
    @Inject(optional=true)
    @Named("mokona.path.chrome.driver")
    private String chromeDriverPath;
    
    @Inject(optional=true)
    @Named("mokona.path.firefox.driver")
    private String firefoxPath;
    
    @Inject(optional=true)
    @Named("mokona.path.ie.driver")
    private String iePath;
    
    @Inject(optional=true)
    @Named("chrome.driver.bin")
    private String chromeDriverBin;
    
    @Inject(optional=true)
    @Named("firefox.driver.bin")
    private String firefoxDriverBin;
    
    @Inject(optional=true)
    @Named("ie.driver.bin")
    private String ieDriverBin;
    
    public WebDriver get() {
        if (driver != null) {
            return driver;
        }
        
        if (chromeDriverPath != null) {
            System.setProperty(chromeDriverBin, chromeDriverPath);
            driver = new ChromeDriver();
            return driver;
        }
        
        if (firefoxPath != null) {
            System.setProperty(firefoxDriverBin, firefoxPath);
            driver = new FirefoxDriver();
            return driver;
        }
        
        if (iePath != null) {
            System.setProperty(ieDriverBin, iePath);
            driver = new InternetExplorerDriver();
            return driver;
        }
        
        throw new MokonaException("WebDriver not founded. Verify that the path to implementation of WebDriver is in the configuration file.");
    }

}
