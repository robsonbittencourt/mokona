package com.mokona.page;

import java.lang.reflect.Field;

import com.mokona.element.Element;

public class BasePage {

	public BasePage() {
		try {
			initElements();
		} catch (Exception e) {
			System.out.println("Error on instantiate elements of page.");
		}
	}

	private void initElements() throws Exception {
		Field[] fields = this.getClass().getDeclaredFields();
		for (Field field : fields) {
			if (field.isAnnotationPresent(Element.class)) {
				Element annotation = field.getAnnotation(Element.class);
				Object newInstance = field.getType().newInstance();

				Field declaredField = newInstance.getClass().getSuperclass().getDeclaredField("selector");
				declaredField.setAccessible(true);
				declaredField.set(newInstance, annotation.selector());

				field.set(this, newInstance);
			}
		}
	}

}