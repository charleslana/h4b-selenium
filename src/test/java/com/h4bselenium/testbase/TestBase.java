package com.h4bselenium.testbase;

import com.h4bselenium.components.PropertiesOperations;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestBase {

    BrowserFactory browserFactory = new BrowserFactory();

    @BeforeMethod
    public void launchApplication() {
        String browser = PropertiesOperations.getPropertyValueByKey("browser");
        String url = PropertiesOperations.getPropertyValueByKey("url");
        DriverFactory.getInstance().setDriver(browserFactory.createBrowserInstance(browser));
        DriverFactory.getInstance().getDriver().manage().window().maximize();
        DriverFactory.getInstance().getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        DriverFactory.getInstance().getDriver().navigate().to(url);
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.getInstance().closeBrowser();
    }
}
