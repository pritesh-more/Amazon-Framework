package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignIn {

	public WebDriver driver;
	
	private By email = By.id("ap_email");
	private By submit = By.id("continue");
	
	public SignIn(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public WebElement getEmail()
	{
		return driver.findElement(email);
	}
	
	public WebElement getContinue()
	{
		return driver.findElement(submit);
	}
	
}
