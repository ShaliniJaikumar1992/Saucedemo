package pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage {

	WebDriver driver;

	By Text_username = By.xpath("//input[@id='user-name']");
	By Text_password = By.xpath("//input[@id='password']");
	By Btn_Login = By.xpath("//input[@id='login-button']");

	//Constructors

	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
	}
	// method to enter username and password 
	public void EnterValidCredentials(String Username,String Password) 
	{

		driver.findElement(Text_username).sendKeys(Username);
		driver.findElement(Text_password).sendKeys(Password);
		System.out.println("Username:"+ Username);
		System.out.println("Password:"+ Password);
	}
	// method to click on login button
	public void ClickonLoginbutton()
	{
		driver.findElement(Btn_Login).click();

	}
	
	
}
