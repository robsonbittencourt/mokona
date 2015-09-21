package com.mokona.injection;

import java.lang.reflect.Field;

import javax.inject.Inject;

import com.google.inject.Injector;
import com.google.inject.MembersInjector;
import com.google.inject.TypeLiteral;
import com.google.inject.spi.TypeEncounter;
import com.google.inject.spi.TypeListener;
import com.mokona.core.Element;
import com.mokona.core.MokonaElement;
import com.mokona.core.SelectorFactory;

public class ElementTypeListener implements TypeListener {

    @Inject
    private Injector injector;
    
    @Inject 
    private SelectorFactory selectorFactory;

    public <T> void hear(TypeLiteral<T> type, TypeEncounter<T> encounter) {
        Class<?> baseClass = type.getRawType();

        while (baseClass != null) {
            for (Field field : baseClass.getDeclaredFields()) {
                if (MokonaElement.class.isAssignableFrom(field.getType()) && field.isAnnotationPresent(Element.class)) {
                    encounter.register(createElementInjector(field));
                }
            }
            baseClass = baseClass.getSuperclass();
        }
    }

    private <T> MembersInjector<T> createElementInjector(Field field) {
        return new ElementMembersInjector<T>(injector, field, selectorFactory);
    }

}
