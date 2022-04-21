package com.h4bselenium.testbase;

import com.aventstack.extentreports.ExtentTest;

public class ExtentFactory {

    private static final ExtentFactory instance = new ExtentFactory();
    ThreadLocal<ExtentTest> extent = new ThreadLocal<>();

    private ExtentFactory() {

    }

    public static ExtentFactory getInstance() {
        return instance;
    }

    public ExtentTest getExtent() {
        return extent.get();
    }

    public void setExtent(ExtentTest extentTestObject) {
        extent.set(extentTestObject);
    }

    public void removeExtentObject() {
        extent.remove();
    }
}
