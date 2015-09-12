package com.mokona.injection;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class InjectorCreator {
    
    public static Injector mockInjector = null; //used to simplify testing

    public static Injector createInjector() {
        if (mockInjector != null)
            return mockInjector;

        return Guice.createInjector(new InjectionModule());
    }

}
