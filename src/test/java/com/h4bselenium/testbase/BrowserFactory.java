package com.h4bselenium.testbase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BrowserFactory {

    public WebDriver createBrowserInstance(String browser) {
        WebDriver driver = null;
        if (browser.equalsIgnoreCase("Chrome")) {
            driver = setupChrome();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = setupFirefox();
        } else if (browser.equalsIgnoreCase("edge")) {
            driver = setupEdge();
        }
        return driver;
    }

    private WebDriver setupChrome() {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.silentOutput", "true");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");// --headless
        driver = new ChromeDriver(chromeOptions);
        return driver;
    }

    private WebDriver setupEdge() {
        WebDriver driver;
        WebDriverManager.edgedriver().setup();
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("-private");
        driver = new EdgeDriver(edgeOptions);
        return driver;
    }

    private WebDriver setupFirefox() {
        WebDriver driver;
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("-private");
        driver = new FirefoxDriver(firefoxOptions);
        return driver;
    }
}
