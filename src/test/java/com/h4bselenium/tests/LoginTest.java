package com.h4bselenium.tests;

import com.h4bselenium.pageobjects.LoginPageObjects;
import com.h4bselenium.testbase.DriverFactory;
import com.h4bselenium.testbase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    LoginPageObjects loginPageObjects;

    @BeforeMethod
    public void getWebDriver() {
        loginPageObjects = new LoginPageObjects(DriverFactory.getInstance().getDriver());
    }

    @Test
    public void loginFail() {
        loginPageObjects.login("test@test.com", "1234567");
        loginPageObjects.validateLoginError();
    }

    @Test
    public void loginSuccess() {
        loginPageObjects.login("test@test.com", "123456");
        loginPageObjects.waitNavigateToDashboard();
    }
}
