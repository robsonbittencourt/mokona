package com.mokona.injection;

import org.openqa.selenium.WebDriver;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.mokona.driver.DriverFactory;

public class InjectionModule extends AbstractModule {
    
    @Override
    protected void configure() {
       
    }
    
    @Provides
    private WebDriver provideWebDriver(DriverFactory driverFactory) {
       return driverFactory.get();
    }

}
