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
import resources.base;

public class HomePage extends base{

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
	public void homePageValidation() throws IOException
	{
		MainPage MP = new MainPage(driver);
		Assert.assertEquals(MP.getLabel().getText(), "Today's Deals");
		log.info("'Today's Deals' label is matched");
		
	}
	
	@AfterTest
	public void closeBrowser()
	{
		driver.close();
		log.info("Label Validation Test Completed");
	}
}
