package Amazon;


import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObject.AddToCart;
import PageObject.ComputerAccessories;
import PageObject.MainPage;
import resources.base;

public class Accessories extends base{

	public WebDriver driver;
	public static Logger log = LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void initialization() throws IOException
	{
		driver = initializeDriver();
		driver.get(properties.getProperty("url"));
		log.info("Initialized Browser");
	}
	
	@Test
	public void computerAccessories()
	{
		MainPage MP = new MainPage(driver);
		ComputerAccessories CA  = MP.getCA();
		log.info("Clicked on Computer Accessories");
		
		AddToCart ATD = CA.getProduct();
		ATD.getAddToCart().click();
		log.info("Product added to cart");
		Assert.assertEquals(ATD.getCartDetails().getText(), "Added to Cart");
		log.info("Product added Successfully");
		System.out.println(ATD.getCartDetails().getText());
		
	}
	
	@AfterTest
	public void closeBrowser()
	{
		log.info("Accessories Added to Cart Test Completed");
		driver.close();
	}
}
