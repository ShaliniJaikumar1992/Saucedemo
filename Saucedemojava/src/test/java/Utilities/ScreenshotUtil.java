package Utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {
    public static String takeScreenshot(WebDriver driver, String name) {
        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String path = "test-output/screenshots/" + name + "_" + timestamp + ".png";

        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File dest = new File(path);
        dest.getParentFile().mkdirs();
        try {
            Files.copy(src.toPath(), dest.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return path;
    }
}