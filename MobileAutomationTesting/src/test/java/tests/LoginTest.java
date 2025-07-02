package tests;

import Base.BaseTest;

import org.testng.Assert;

import org.testng.annotations.Test;

import Pages.HomePage;

import Pages.LoginPage;

import Utilities.DriverManager;

import Utilities.RetryAnalyzer;



public class LoginTest extends BaseTest {



    @Test(dataProvider = "loginData", dataProviderClass = Data.TestDataProvider.class, retryAnalyzer = RetryAnalyzer.class)

    public void testValidLogin(String username, String password) {

        // Create LoginPage instance

        LoginPage loginPage = new LoginPage(DriverManager.getDriver());



        // Perform login

        loginPage.login(username, password);

        test.info("Login attempted with username: " + username);



        // Create HomePage instance

        HomePage homePage = new HomePage(DriverManager.getDriver());



        // Validate welcome message (example validation)

        String message = homePage.getWelcomeMessage();

        test.info("Captured welcome message: " + message);

        Assert.assertTrue(message.contains("Welcome"), "Login failed or welcome message not found");



        // Perform logout (optional)

        homePage.logout();

        test.info("Logged out successfully");

    }

}
