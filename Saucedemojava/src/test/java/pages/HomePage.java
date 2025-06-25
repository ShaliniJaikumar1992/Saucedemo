package pages;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.testng.Assert;

public class HomePage {
	WebDriver driver;

	By Btn_item1 = By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']");
	By Btn_item2 = By.xpath("//button[@id='add-to-cart-sauce-labs-bike-light']");
	By Btn_item3 = By.xpath("//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']");
	By Btn_item4 = By.xpath("//button[@id='add-to-cart-sauce-labs-fleece-jacket']");
	By Btn_item5 = By.xpath("//button[@id='add-to-cart-sauce-labs-onesie']");
	By Btn_item6 = By.xpath("//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']");

	//Constructors

	public HomePage(WebDriver driver)
	{
		this.driver = driver;
	}


	public void GetTitleofpage() {
		long time = 2000;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));		
		String title = driver.getTitle();		
		Assert.assertEquals("Swag Labs",title);	
		System.out.println(title);
		 
	}

	public void AddItemToCart() {
		long time = 2000;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
		
		driver.findElement(Btn_item1).click();
		driver.findElement(Btn_item2).click();
		driver.findElement(Btn_item3).click();
		driver.findElement(Btn_item4).click();
		driver.findElement(Btn_item5).click();
		driver.findElement(Btn_item6).click();
	}
}
