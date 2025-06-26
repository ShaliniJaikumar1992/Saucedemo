package StepDefinitions;


import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.cucumber.java.After;
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


	}

	@When("the User enter {string} and {string}")
	public void the_User_enter_username_and_password(String username, String password) {

		loginpage = new LoginPage(driver);

		loginpage.EnterValidCredentials(username, password);
		 

	}



	@And("click on login button")
	public void click_on_login_button() {

		loginpage.ClickonLoginbutton();		
		long time = 2000;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
	}

	@Then("The user should be on home page")
	public void the_user_should_be_on_home_page() {
		homepage = new HomePage(driver);
		
		homepage.GetTitleofpage();

	}

	@Then("user need to add items to the cart")
	public void user_need_to_add_items_to_the_cart() {
		
		homepage.AddItemToCart();
		
	}

	@Then("select the check out option")
	public void select_the_check_out_option() {
		
		checkoutpage = new CheckoutPage(driver);
		
		checkoutpage.checkoutItemfromCart();
		
	}

	@Then("user enter the information asked {string},{string},{string}")
	public void user_enter_the_information_asked_Name_lastname_pincode(String name,String lastname,String pincode) {
		enterinformationpage = new EnterInformationPage(driver);
		
		enterinformationpage.Enterdetails(name,lastname,pincode);

	}

	@Then("click on finish button")
	public void click_on_finish_button() {
		enterinformationpage.ClickOnFinishbutton();
	}

	@Then("verify the {string} message")

	public void verify_the_message(String message) {
		
		enterinformationpage.verifyThankyoumessage(message); 
		
	}
	
	

}
