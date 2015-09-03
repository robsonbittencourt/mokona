package com.mokona.element;

import org.openqa.selenium.Keys;

import com.mokona.core.MokonaElement;

public class DropDown extends MokonaElement {

    public void select(String item) {
        getWebElement().click();
        getWebElement().sendKeys(item);

        getWebElement().sendKeys(Keys.ENTER);
    }

}
