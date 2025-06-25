package pages;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CheckoutPage {
	
	WebDriver driver;
	//Constructors

		public CheckoutPage(WebDriver driver)
		{
			this.driver = driver;
		}
		
		By Link_item1 = By.xpath("//a[@id='item_0_title_link']//div");
		By Link_item2 = By.xpath("//a[@id='item_1_title_link']//div");
		By Link_item3 = By.xpath("//a[@id='item_2_title_link']//div");
		By Link_item4 = By.xpath("//a[@id='item_3_title_link']//div");
		By Link_item5 = By.xpath("//a[@id='item_4_title_link']//div");
		By Link_item6 = By.xpath("//a[@id='item_5_title_link']//div");
		
		public void checkoutItemfromCart() 
		
		{
			long time = 2000;
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
			
			driver.findElement(By.xpath("//div[@id='shopping_cart_container']//a")).click();
			
			String itemname1 = driver.findElement(Link_item1).getText();
			Assert.assertEquals("Sauce Labs Bike Light", itemname1);	
			
			String itemname2 = driver.findElement(Link_item2).getText();
			Assert.assertEquals("Sauce Labs Bolt T-Shirt", itemname2);
			
			String itemname3 = driver.findElement(Link_item3).getText();
			Assert.assertEquals("Sauce Labs Onesie", itemname3);
			
			String itemname4 = driver.findElement(Link_item4).getText();
			Assert.assertEquals("Test.allTheThings() T-Shirt (Red)", itemname4);
			
			String itemname5 = driver.findElement(Link_item5).getText();
			Assert.assertEquals("Sauce Labs Backpack", itemname5);
			
			String itemname6 = driver.findElement(Link_item6).getText();
			Assert.assertEquals("Sauce Labs Fleece Jacket", itemname6);
			
			driver.findElement(By.xpath("//button[@id='checkout']")).click();
		}
		
		
		
		
}
