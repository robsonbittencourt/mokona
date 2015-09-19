package com.mokona.injection;

import org.openqa.selenium.WebDriver;

import com.google.inject.AbstractModule;
import com.google.inject.matcher.Matchers;
import com.mokona.webdriver.WebDriverProvider;

public class InjectionModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(WebDriver.class).toProvider(WebDriverProvider.class);

        ElementTypeListener listener = new ElementTypeListener();
        requestInjection(listener);
        bindListener(Matchers.any(), listener);
    }

}
