package com.mokona.wait;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
* 
* Adapted from https://github.com/ChonC/wtbox/blob/master/src/wtbox/util/WaitTool.java#L194
* 
* @author Chon Chung, Mark Collin, Andre, Tarun Kumar 
* 
* Copyright [2012] [Chon Chung]
* 
* Licensed under the Apache Open Source License, Version 2.0  
* http://www.apache.org/licenses/LICENSE-2.0
*
*/

public class WaitTool {
	
	public static final int DEFAULT_WAIT_4_ELEMENT = 15; 
	public static final int DEFAULT_WAIT_4_PAGE = 30; 

	public static WebElement waitForElement(WebDriver driver, final By by, int timeOutInSeconds) {
		WebElement element; 
		try{	
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			  
			WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds); 
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			
			driver.manage().timeouts().implicitlyWait(DEFAULT_WAIT_4_PAGE, TimeUnit.SECONDS); 
			return element; 	
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return null; 
	}
	

}
