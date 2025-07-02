package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {
    private static ExtentReports extent;
    public static ExtentTest test;

    public static void initReport() {
        ExtentSparkReporter spark = new ExtentSparkReporter("test-output/ExtentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(spark);
    }

    public static ExtentReports getReport() {
        return extent;
    }

    public static void flushReport() {
        if (extent != null) extent.flush();
    }

    public static void attachScreenshot(String path) {
        try {
            test.fail("Screenshot:", MediaEntityBuilder.createScreenCaptureFromPath(path).build());
        } catch (Exception e) {
            test.warning("Failed to attach screenshot: " + e.getMessage());
        }
    }
}