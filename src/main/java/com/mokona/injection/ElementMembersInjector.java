package com.mokona.injection;

import static org.apache.commons.lang3.StringUtils.isNotEmpty;

import java.lang.reflect.Field;

import org.openqa.selenium.By;

import com.google.inject.Injector;
import com.google.inject.MembersInjector;
import com.mokona.core.Element;
import com.mokona.core.MokonaElement;
import com.mokona.exception.MokonaException;

public class ElementMembersInjector<T> implements MembersInjector<T> {

	private Injector injector;
	private Field elementField;

	public ElementMembersInjector(Injector injector, Field elementField) {
		this.injector = injector;
		this.elementField = elementField;
		this.elementField.setAccessible(true);
	}

	public void injectMembers(T page) {
		try {
			Element element = elementField.getAnnotation(Element.class);
			setSelector(page, element);
		} catch (Exception e) {
			throw new MokonaException(e.getMessage(), e);
		}
	}

	private void setSelector(Object page, Element annotation) throws Exception {
		MokonaElement element = (MokonaElement) injector.getInstance(elementField.getType());
		element.setSelector(buildSelector(annotation));
		elementField.set(page, element);
	}

	private By buildSelector(Element annotation) {
		if (isNotEmpty(annotation.css()))
			return By.cssSelector(annotation.css());

		return null;
	}

}
