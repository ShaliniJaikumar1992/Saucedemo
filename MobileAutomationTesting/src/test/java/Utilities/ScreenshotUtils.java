package Utilities;

import io.appium.java_client.AppiumDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;

public class ScreenshotUtils {
    public static String takeScreenshot(AppiumDriver driver, String name) {
        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String path = "test-output/screenshots/" + name + ".png";
            File dest = new File(path);
            FileUtils.copyFile(src, dest);
            return path;
        } catch (Exception e) {
            return null;
        }
    }
}