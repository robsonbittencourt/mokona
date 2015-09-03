package com.mokona.core;

import java.lang.reflect.Field;

import org.openqa.selenium.WebDriver;

import com.mokona.driver.DriverFactory;
import com.mokona.exception.MokonaException;

public abstract class MokonaPage {

    protected WebDriver driver;

    public MokonaPage() {
        try {
            driver = DriverFactory.get();
            initElements();
        } catch (Exception e) {
            throw new MokonaException("Error on instantiate elements of page.");
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