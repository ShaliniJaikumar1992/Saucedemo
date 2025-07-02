package utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.nio.file.Files;

public class ScreenshotUtils {
    public static String capture(WebDriver driver, String testName) {
        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File dest = new File("screenshots/" + testName + ".png");
            Files.copy(src.toPath(), dest.toPath());
            return dest.getAbsolutePath();
        } catch (Exception e) {
            return "Screenshot failed: " + e.getMessage();
        }
    }
}