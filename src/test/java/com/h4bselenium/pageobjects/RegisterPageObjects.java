package com.h4bselenium.pageobjects;

import com.h4bselenium.components.ActionEngine;
import com.h4bselenium.testbase.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPageObjects extends ActionEngine {

    @FindBy(xpath = "//a[normalize-space()='Cadastre-se']")
    private WebElement actionToRegister;
    @FindBy(id = "email")
    private WebElement email;
    @FindBy(id = "name")
    private WebElement name;
    @FindBy(id = "nameCountry")
    private WebElement nameCountry;
    @FindBy(id = "nextButton1")
    private WebElement nextButton1;
    @FindBy(id = "nextButton2")
    private WebElement nextButton2;
    @FindBy(id = "nextButton3")
    private WebElement nextButton3;
    @FindBy(id = "password")
    private WebElement password;
    @FindBy(id = "passwordConfirmation")
    private WebElement passwordConfirmation;
    @FindBy(xpath = "//span[normalize-space()='Usuário da plataforma']")
    private WebElement selectAccountUser;
    @FindBy(xpath = "//h1[normalize-space()='O cadastro foi concluído com sucesso!']")
    private WebElement successfullyRegistered;

    public RegisterPageObjects(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    private void goToStep1(String autoGenerateText) {
        sendKeys(email, autoGenerateText);
        sendKeys(password, autoGenerateText);
        sendKeys(passwordConfirmation, autoGenerateText);
        click(nextButton1);
    }

    private void goToStep2(String autoGenerateText) {
        sendKeys(name, autoGenerateText);
        sendKeys(nameCountry, "Brazil");
        click(nextButton2);
    }

    private void goToStep3(WebElement element) {
        click(element);
        click(nextButton3);
        CommonObjects commonObjects = new CommonObjects(DriverFactory.getInstance().getDriver());
        commonObjects.loading(true);
        commonObjects.loading(false);
    }

    public void register(String autoGenerateText) {
        click(actionToRegister);
        urlContains("/register");
        goToStep1(autoGenerateText);
        goToStep2(autoGenerateText);
        goToStep3(selectAccountUser);
    }

    public void registerSuccess() {
        isElementPresent(successfullyRegistered);
    }
}
