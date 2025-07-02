package Pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileActions;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private AppiumDriver driver;

    // Constructor to initialize elements
    public HomePage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Locators
    @AndroidFindBy(id = "com.example:id/welcomeMessage")
    private MobileActions welcomeText;

    @AndroidFindBy(id = "com.example:id/logoutBtn")
    private MobileActions logoutButton;

    // Methods
    public String getWelcomeMessage() {
        return welcomeText.getText();
    }

    public void logout() {
        logoutButton.click();
    }
}