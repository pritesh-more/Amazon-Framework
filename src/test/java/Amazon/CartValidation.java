package Amazon;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObject.MainPage;
import PageObject.cart;
import resources.base;

public class CartValidation extends base{

	public WebDriver driver;
	public static Logger log = LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void Initialization() throws IOException
	{
		driver = initializeDriver();
		driver.get(properties.getProperty("url"));
		log.info("Initialized Browser");
	}
	
	@Test
	public void CartDetails()
	{
		MainPage MP = new MainPage(driver);
		cart c = MP.getCart();
		Assert.assertEquals(c.getCartLabel().getText(), "Your Amazon Cart is empty");
		log.info("Cart is empty checked");
		System.out.println(c.getCartLabel().getText());
		
	}
	
	@AfterTest
	public void closeBrowser()
	{
		driver.close();
		log.info("Cart Empty Test Completed");
	}
}
