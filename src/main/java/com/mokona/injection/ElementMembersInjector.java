package com.mokona.injection;

import java.lang.reflect.Field;

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
			setSelector(page, element.selector());
		} catch (Exception e) {
			throw new MokonaException(e.getMessage(), e);
		}
	}

	private void setSelector(Object page, String selector) throws Exception {
		MokonaElement element = (MokonaElement) injector.getInstance(elementField.getType());
		Field selectorField = elementField.getType().getSuperclass().getDeclaredField("selector");
		selectorField.setAccessible(true);
		selectorField.set(element, selector);
		elementField.set(page, element);
	}

}
