package Amazon;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObject.MainPage;
import PageObject.SignIn;
import resources.base;

public class SignInValidation extends base{

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
	public void signIn()
	{
		MainPage MP = new MainPage(driver);
		
		Actions action = new Actions(driver);
		action.moveToElement(MP.getCursorOnSignIn()).build().perform();
		
		SignIn SI = MP.getSignIn();
		log.info("Clicked on Sign-In");
		
		SI.getEmail().sendKeys("sfg@gd.df");
		SI.getContinue().click();
		log.info("Credentials sent and submitted");
		
	}
	
	@AfterTest
	public void closeBrowser()
	{
		driver.close();
		log.info("Sign In Test Completed");
	}
}
