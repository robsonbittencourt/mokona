package com.mokona.page;

import org.junit.Test;

import com.mokona.config.Config;
import com.mokona.drive.Driver;

public class GooglePageTest {

	@Test
	public void shouldSearchTermInGoogleMainPage() {
		Config config = new Config();

		GooglePage page = new GooglePage();

		Driver.getDriver().navigate().to(config.getConfig("url"));

		page.textToSearch.set("selenium");
	}

}
