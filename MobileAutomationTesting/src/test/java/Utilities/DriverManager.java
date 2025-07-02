package Utilities;


	import io.appium.java_client.AppiumDriver;
	import io.appium.java_client.android.AndroidDriver;
	import org.openqa.selenium.remote.DesiredCapabilities;

	import java.net.URL;

	public class DriverManager {
	    private static AppiumDriver driver;

	    public static void initDriver() throws Exception {
	        DesiredCapabilities caps = new DesiredCapabilities();
	        caps.setCapability("platformName", "Android");
	        caps.setCapability("deviceName", "emulator-5554");
	        caps.setCapability("app", System.getProperty("user.dir") + "/app/app-debug.apk");

	        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
	    }

	    public static AppiumDriver getDriver() {
	        return driver;
	    }

	    public static void quitDriver() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }
	}

