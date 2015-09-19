package com.mokona.injection;

import org.openqa.selenium.WebDriver;

import com.google.inject.AbstractModule;
import com.google.inject.matcher.Matchers;
import com.google.inject.name.Names;
import com.mokona.properties.MokonaProperties;
import com.mokona.webdriver.WebDriverProvider;

public class InjectionModule extends AbstractModule {
    
    @Override
    protected void configure() {
        bindProperties();
        bind(WebDriver.class).toProvider(WebDriverProvider.class);

        ElementTypeListener listener = new ElementTypeListener();
        requestInjection(listener);
        bindListener(Matchers.any(), listener);
    }

    private void bindProperties() {
        MokonaProperties mokonaProperties = new MokonaProperties();
        Names.bindProperties(binder(), mokonaProperties.loadInternalPropertiesFile());
        Names.bindProperties(binder(), mokonaProperties.loadUserPropertiesFile());
    }
    
}
