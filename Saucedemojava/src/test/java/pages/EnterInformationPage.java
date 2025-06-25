package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class EnterInformationPage {
	
	WebDriver driver;
	
	public EnterInformationPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By Txt_name = By.xpath("//input[@id='first-name']");
	By Txt_lastname = By.xpath("//input[@id='last-name']");
	By Txt_Pincode = By.xpath("//input[@id='postal-code']");
	By btn_Continue =By.xpath("//input[@id='continue']");
	By btn_Finish =By.xpath("//button[@id='finish']");
	By label_msg =By.xpath("//div[@id='checkout_complete_container']//h2");
	
	public void Enterdetails(String Name,String LastName,String Pincode)
	{
		long time = 2000;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
		driver.findElement(Txt_name).sendKeys(Name);
		driver.findElement(Txt_lastname).sendKeys(LastName);
		driver.findElement(Txt_Pincode).sendKeys(Pincode);
		driver.findElement(btn_Continue).click();

	}
	
	public void ClickOnFinishbutton()
	{
		long time = 2000;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
		driver.findElement(btn_Finish).click();
	}
	
	public void verifyThankyoumessage(String message)
	{
		
		long time = 2000;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
		String thankyoumessage = driver.findElement(label_msg).getText();
		Assert.assertEquals(message, thankyoumessage);
		System.out.println(message);
		driver.quit();
	}
}
