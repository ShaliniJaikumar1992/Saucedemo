package Pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileActions;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private AppiumDriver driver;

    // Constructor to initialize driver and page elements
    public LoginPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Locators
    @AndroidFindBy(id = "com.example:id/username")
    private MobileActions usernameInput;

    @AndroidFindBy(id = "com.example:id/password")
    private MobileActions passwordInput;

    @AndroidFindBy(id = "com.example:id/loginBtn")
    private MobileActions loginButton;

    // Action Method
    public void login(String username, String password) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
    }
}
