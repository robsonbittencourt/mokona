package com.mokona.injection;

import java.lang.reflect.Field;

import com.google.inject.Injector;
import com.google.inject.MembersInjector;
import com.mokona.core.Element;
import com.mokona.core.MokonaElement;
import com.mokona.core.SelectorFactory;
import com.mokona.exception.MokonaException;

public class ElementMembersInjector<T> implements MembersInjector<T> {

    private Injector injector;
    private Field elementField;
    private SelectorFactory selectorFactory;

    public ElementMembersInjector(Injector injector, Field elementField, SelectorFactory selectorFactory) {
        this.injector = injector;
        this.elementField = elementField;
        this.selectorFactory = selectorFactory;
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
        
        try {
            element.setSelector(selectorFactory.build(annotation));
        } catch (MokonaException e) {
            throw new MokonaException(String.format("The page %s contain an element %s without the selector parameter", page.getClass(), element.getClass()));
        }
        
        elementField.set(page, element);
    }

}
