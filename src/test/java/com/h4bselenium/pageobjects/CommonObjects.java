package com.h4bselenium.pageobjects;

import com.h4bselenium.components.ActionEngine;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CommonObjects {

    @FindBy(xpath = "//div[@role='alert']")
    public WebElement toastError;
    @FindBy(className = "is-loading")
    private List<WebElement> isLoading;

    public CommonObjects(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    public void loading(Boolean isLoading) {
        ActionEngine actionEngine = new ActionEngine();
        if (isLoading) {
            actionEngine.isElementPresent(this.isLoading.get(0));
        } else {
            actionEngine.isNotElementPresent(this.isLoading.get(0));
        }
    }
}
