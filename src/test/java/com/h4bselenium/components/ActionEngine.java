package com.h4bselenium.components;

import com.aventstack.extentreports.Status;
import com.h4bselenium.testbase.DriverFactory;
import com.h4bselenium.testbase.ExtentFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class ActionEngine {

    private final WebDriver driver = DriverFactory.getInstance().getDriver();

    private WebDriverWait await() {
        return new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void click(WebElement element) {
        try {
            ExtentFactory.getInstance().getExtent().log(Status.PASS, String.format("Action %s clicked successfully.", element));
            element.click();
        } catch (Exception e) {
            ExtentFactory.getInstance().getExtent().log(Status.FAIL, String.format("Action: %s is failed due to exception: %s", element, e));
        }
    }

    public void isElementPresent(WebElement element) {
        try {
            Assert.assertTrue(element.isDisplayed());
            ExtentFactory.getInstance().getExtent().log(Status.PASS, String.format("%s presence of element successfully.", element));
        } catch (Exception e) {
            ExtentFactory.getInstance().getExtent().log(Status.FAIL, String.format("%s presence of element is failed due to exception: %s", element, e));
        }
    }

    public void isNotElementPresent(WebElement element) {
        try {
            await().until(ExpectedConditions.invisibilityOf(element));
            Assert.assertFalse(element.isDisplayed());
            ExtentFactory.getInstance().getExtent().log(Status.PASS, String.format("%s is not presence of element successfully.", element));
        } catch (Exception e) {
            ExtentFactory.getInstance().getExtent().log(Status.FAIL, String.format("%s is not presence of element is failed due to exception: %s", element, e));
        }
    }

    public void sendKeys(WebElement element, String valueToBeSent) {
        try {
            element.sendKeys(valueToBeSent);
            ExtentFactory.getInstance().getExtent().log(Status.PASS, String.format("%s entered value as: %s", element, valueToBeSent));
        } catch (Exception e) {
            ExtentFactory.getInstance().getExtent().log(Status.FAIL, String.format("Value entered in field: %s is failed due to exception: %s", element, e));
        }
    }

    public void urlContains(String urlPath) {
        try {
            await().until(ExpectedConditions.urlContains(urlPath));
            ExtentFactory.getInstance().getExtent().log(Status.PASS, String.format("Url contains path %s successfully.", urlPath));
        } catch (Exception e) {
            ExtentFactory.getInstance().getExtent().log(Status.FAIL, String.format("Url with path %s is failed due to exception: %s", urlPath, e));
            Assert.assertEquals(driver.getCurrentUrl(), PropertiesOperations.getPropertyValueByKey("url").concat(urlPath));
        }
    }
}
