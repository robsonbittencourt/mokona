package com.mokona.core;

import java.lang.reflect.Field;

import org.openqa.selenium.WebDriver;

import com.mokona.drive.Driver;
import com.mokona.wait.WaitTool;

public abstract class BasePage {
	
	protected WebDriver driver;
	
	public BasePage() {
		try {
			driver = Driver.getDriver();
			initElements();
		} catch (Exception e) {
			System.out.println("Error on instantiate elements of page.");
		}
	}
	
	public abstract void goTo();
	
	private void initElements() throws Exception {
		Field[] fields = this.getClass().getDeclaredFields();
		for (Field field : fields) {
			if (field.isAnnotationPresent(Element.class)) {
				Element annotation = field.getAnnotation(Element.class);
				Object newInstance = field.getType().newInstance();

				Field declaredField = newInstance.getClass().getSuperclass().getDeclaredField("selector");
				declaredField.setAccessible(true);
				declaredField.set(newInstance, annotation.selector());
				
				field.setAccessible(true);
				field.set(this, newInstance);
			}
		}
	}

}