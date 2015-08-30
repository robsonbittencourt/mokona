package com.mokona.element;

import org.openqa.selenium.Keys;

import com.mokona.core.MokonaElement;

public class DropDown extends MokonaElement {

    public void select(String item) {
        getElement().click();
        getElement().sendKeys(item);

        getElement().sendKeys(Keys.ENTER);
    }

}
