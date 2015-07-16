package com.mokona.page;

import com.mokona.element.Button;
import com.mokona.element.Element;
import com.mokona.element.TextField;


public class GooglePage extends BasePage {

	@Element(selector = "#lst-ib")
	public TextField textToSearch;

	@Element(selector = "[name='btnG']")
	public Button search;

}
