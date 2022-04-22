package com.h4bselenium.testbase;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.h4bselenium.components.PropertiesOperations;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReportNG {

    static ExtentReports extent;

    public static ExtentReports setupExtentReport() throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyy HH-mm-ss");
        Date date = new Date();
        String actualDate = format.format(date);
        String reportPath = System.getProperty("user.dir").concat(String.format("/src/test/resources/reports/ExecutionReport_%s.html", actualDate));
        ExtentSparkReporter sparkReport = new ExtentSparkReporter(reportPath);
        return setupExtent(sparkReport);
    }

    private static ExtentReports setupExtent(ExtentSparkReporter sparkReport) {
        extent = new ExtentReports();
        extent.attachReporter(sparkReport);
        sparkReport.config().setDocumentTitle("DocumentTitle");
        sparkReport.config().setTheme(Theme.DARK);
        sparkReport.config().setReportName("ReportName");
        extent.setSystemInfo("Executed on Environment: ", PropertiesOperations.getPropertyValueByKey("url"));
        extent.setSystemInfo("Executed on Browser: ", PropertiesOperations.getPropertyValueByKey("browser"));
        extent.setSystemInfo("Executed on OS: ", System.getProperty("os.name"));
        extent.setSystemInfo("Executed by User: ", System.getProperty("user.name"));
        return extent;
    }
}
