package Base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.appium.java_client.AppiumDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import Utilities.DriverManager;
import Utilities.ExtentReportManager;
import Utilities.ScreenshotUtils;

import java.lang.reflect.Method;

public class BaseTest {
    protected ExtentReports report;
    protected ExtentTest test;
    protected AppiumDriver driver;

    @BeforeMethod
    public void setUp(Method method) throws Exception {
        // Start report
        report = ExtentReportManager.getReportInstance();
        test = report.createTest(method.getName());

        // Initialize driver
        DriverManager.initDriver();
        driver = DriverManager.getDriver();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            test.fail(result.getThrowable());
            // Capture screenshot
            String screenshotPath = ScreenshotUtils.takeScreenshot(driver, result.getName());
            if (screenshotPath != null) {
                test.addScreenCaptureFromPath(screenshotPath);
            }
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.pass("Test passed successfully");
        } else if (result.getStatus() == ITestResult.SKIP) {
            test.skip("Test was skipped");
        }

        // Quit driver and flush report
        DriverManager.quitDriver();
        report.flush();
    }
}