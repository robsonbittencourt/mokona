package com.mokona.core;

import static com.mokona.injection.InjectorCreator.getInjector;

import com.mokona.exception.MokonaException;

public abstract class MokonaPage {

	public MokonaPage() {
		try {
			getInjector().injectMembers(this);
		} catch (Exception e) {
			throw new MokonaException("Error on instantiate elements of page.", e);
		}
	}

	public abstract void goTo();

}
