package com.h4bselenium.tests;

import com.h4bselenium.pageobjects.RegisterPageObjects;
import com.h4bselenium.testbase.DriverFactory;
import com.h4bselenium.testbase.TestBase;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterTest extends TestBase {

    RegisterPageObjects registerPageObjects;

    @BeforeMethod
    public void getWebDriver() {
        registerPageObjects = new RegisterPageObjects(DriverFactory.getInstance().getDriver());
    }

    @Test
    public void registerSuccess() {
        String autoGenerateText = String.format("user_automated%s%s", RandomStringUtils.randomAlphabetic(10), "@test.com");
        registerPageObjects.register(autoGenerateText);
    }
}
