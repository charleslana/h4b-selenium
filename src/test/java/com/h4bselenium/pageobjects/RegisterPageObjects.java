package com.h4bselenium.pageobjects;

import com.h4bselenium.components.ActionEngine;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPageObjects extends ActionEngine {

    @FindBy(xpath = "//a[normalize-space()='Cadastre-se']")
    private WebElement actionToRegister;

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "passwordConfirmation")
    private WebElement passwordConfirmation;

    public RegisterPageObjects(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    private void goToStep1(String autoGenerateText) {
        sendKeys(email, autoGenerateText);
        sendKeys(password, autoGenerateText);
        sendKeys(passwordConfirmation, autoGenerateText);
    }

    public void register(String autoGenerateText) {
        click(actionToRegister);
        urlContains("/register");
        goToStep1(autoGenerateText);
    }
}
