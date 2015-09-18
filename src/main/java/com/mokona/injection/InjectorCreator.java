package com.mokona.injection;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class InjectorCreator {

	private static Injector INJECTOR = null;

	public static Injector getInjector() {
		if (INJECTOR == null)
			INJECTOR = Guice.createInjector(new InjectionModule());
		return INJECTOR;
	}

}
