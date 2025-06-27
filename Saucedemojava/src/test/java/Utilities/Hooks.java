package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;

public class Hooks {
    public static ExtentReports extent;
    public static ExtentTest test;

    @Before
    public void setup(Scenario scenario) {
        extent = ExtentManager.getReportInstance(); // Get singleton ExtentReports
        test = extent.createTest(scenario.getName());
        test.info("Scenario started");
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            test.fail("Scenario failed: " + scenario.getName());
        } else {
            test.pass("Scenario passed: " + scenario.getName());
        }
        extent.flush();
    }
}

