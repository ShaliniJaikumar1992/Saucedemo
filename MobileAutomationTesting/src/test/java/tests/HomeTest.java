package tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import Pages.HomePage;
import Pages.LoginPage;
import Utilities.DriverManager;
import Utilities.RetryAnalyzer;

public class HomeTest extends BaseTest {

    @Test(dataProvider = "loginData", dataProviderClass = Data.TestDataProvider.class, retryAnalyzer = RetryAnalyzer.class)
    public void verifyHomeScreenElements(String username, String password) {
        // Step 1: Login
        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        loginPage.login(username, password);
        test.info("Logged in with user: " + username);

        // Step 2: Validate Home screen elements
        HomePage homePage = new HomePage(DriverManager.getDriver());
        String welcome = homePage.getWelcomeMessage();
        test.info("Welcome message received: " + welcome);

        Assert.assertTrue(welcome.contains("Welcome"), "Welcome message is incorrect or missing");

        // Step 3: Logout (optional)
        homePage.logout();
        test.info("User logged out successfully.");
    }
}