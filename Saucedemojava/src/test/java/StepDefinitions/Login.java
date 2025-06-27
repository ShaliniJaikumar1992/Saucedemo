package StepDefinitions;


import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import Utilities.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CheckoutPage;
import pages.EnterInformationPage;
import pages.HomePage;
import pages.LoginPage;



public class Login {

	WebDriver driver = null;
	LoginPage loginpage;
    HomePage homepage;
    CheckoutPage checkoutpage;
    EnterInformationPage enterinformationpage;
    Hooks hooks;



	@Given("the user launch the saucedemo URL")
	public void the_user_launch_the_saucedemo_url() {
	
		ChromeOptions options = new ChromeOptions();
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_leak_detection", false);
		prefs.put("profile.default_content_setting_values.notifications", 2);
		options.setExperimentalOption("prefs", prefs);
		
		//prefs.put("profile.cred, prefs)
		String projectPath = System.getProperty("user.dir");
		System.out.println(projectPath);
		System.setProperty("Webdriver.chrome.driver",projectPath+"src/test/resources/Driver/chromedriver.exe");
		
		driver = new ChromeDriver(options);
		long time = 2000;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(time));

		driver.manage().window().maximize();


		driver.navigate().to("https://www.saucedemo.com/");
		
		
		
		
		Hooks.test.info("Navigated to Login Page");
	}

	@When("the User enter {string} and {string}")
	public void the_User_enter_username_and_password(String username, String password) {

		loginpage = new LoginPage(driver);

		loginpage.EnterValidCredentials(username, password);
		 
		Hooks.test.info("Entered credentials");

	}



	@And("click on login button")
	public void click_on_login_button() {

		loginpage.ClickonLoginbutton();		
		long time = 2000;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
		Hooks.test.pass("Clicked login button");
	}

	@Then("The user should be on home page")
	public void the_user_should_be_on_home_page() {
		homepage = new HomePage(driver);
		
		homepage.GetTitleofpage();
		Hooks.test.pass("Titlepage validated");
	}

	@Then("user need to add items to the cart")
	public void user_need_to_add_items_to_the_cart() {
		
		homepage.AddItemToCart();
		Hooks.test.pass("added items to cart");
	}

	@Then("select the check out option")
	public void select_the_check_out_option() {
		
		checkoutpage = new CheckoutPage(driver);
		
		checkoutpage.checkoutItemfromCart();
		Hooks.test.pass("Click on Cart image");
	}

	@Then("user enter the information asked {string},{string},{string}")
	public void user_enter_the_information_asked_Name_lastname_pincode(String name,String lastname,String pincode) {
		enterinformationpage = new EnterInformationPage(driver);
		
		enterinformationpage.Enterdetails(name,lastname,pincode);
		Hooks.test.pass("Entered all the information");
	}

	@Then("click on finish button")
	public void click_on_finish_button() {
		enterinformationpage.ClickOnFinishbutton();
		Hooks.test.pass("click on finish button");
	}

	@Then("verify the {string} message")

	public void verify_the_message(String message) {
		
		enterinformationpage.verifyThankyoumessage(message); 
		Hooks.test.pass("Verified Thank you message");
	}
	
	

}
