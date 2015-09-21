package com.mokona.core;

import static org.apache.commons.lang3.StringUtils.isNotEmpty;

import org.openqa.selenium.By;

import com.mokona.exception.MokonaException;

public class SelectorFactory {

    public By build(Element annotation) {
        if (isNotEmpty(annotation.className())) {
            return By.className(annotation.className());
        }

        if (isNotEmpty(annotation.cssSelector())) {
            return By.cssSelector(annotation.cssSelector());
        }
        
        if (isNotEmpty(annotation.id())) {
            return By.id(annotation.id());
        }
        
        if (isNotEmpty(annotation.linkText())) {
            return By.linkText(annotation.linkText());
        }
        
        if (isNotEmpty(annotation.name())) {
            return By.name(annotation.name());
        }
        
        if (isNotEmpty(annotation.partialLinkText())) {
            return By.partialLinkText(annotation.partialLinkText());
        }
        
        if (isNotEmpty(annotation.tagName())) {
            return By.tagName(annotation.tagName());
        }
        
        if (isNotEmpty(annotation.xpath())) {
            return By.xpath(annotation.xpath());
        }

        throw new MokonaException("Annotation Element do not have a selector parameter.");
    }

}
