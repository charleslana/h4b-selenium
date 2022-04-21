package com.h4bselenium.pageobjects;

import com.h4bselenium.components.ActionEngine;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObjects extends ActionEngine {

    @FindBy(id = "email")
    private WebElement email;
    @FindBy(id = "loginButton")
    private WebElement loginButton;
    @FindBy(id = "password")
    private WebElement password;

    public LoginPageObjects(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    public void login(String email, String password) {
        sendKeys(this.email, email);
        sendKeys(this.password, password);
        click(loginButton);
    }

    public void validateLoginError() {
        isElementPresent(toastError);
    }

    public void waitNavigateToDashboard() {
        urlContains("/dashboard");
    }
}
