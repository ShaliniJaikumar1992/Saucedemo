package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
import utilities.ConfigReader;
import utilities.ExtentReportManager;

public class TestBase {
    public static WebDriver driver;

    @BeforeSuite
    public void setupSuite() {
        ConfigReader.loadProperties();
        ExtentReportManager.initReport();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterSuite
    public void tearDownSuite() {
        driver.quit();
        ExtentReportManager.flushReport();
    }
}