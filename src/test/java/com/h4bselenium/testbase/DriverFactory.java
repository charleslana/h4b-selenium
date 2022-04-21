package com.h4bselenium.testbase;

import org.openqa.selenium.WebDriver;

public class DriverFactory {

    private static final DriverFactory instance = new DriverFactory();
    ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private DriverFactory() {
    }

    public static DriverFactory getInstance() {
        return instance;
    }

    public void closeBrowser() {
        driver.get().quit();
        driver.remove();
    }

    public WebDriver getDriver() {
        return driver.get();
    }

    public void setDriver(WebDriver webDriver) {
        driver.set(webDriver);
    }
}
