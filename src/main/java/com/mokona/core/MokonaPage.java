package com.mokona.core;

import static com.mokona.injection.InjectorCreator.getInjector;

import javax.inject.Inject;

import org.openqa.selenium.WebDriver;

import com.mokona.exception.MokonaException;

public abstract class MokonaPage {

	@Inject
	private WebDriver driver;

	public MokonaPage() {
		try {
			getInjector().injectMembers(this);
		} catch (Exception e) {
			throw new MokonaException("Error on instantiate elements of page.", e);
		}
	}

	protected abstract String getUri();

	public void goTo() {
		driver.get(getUri());
	}

}
