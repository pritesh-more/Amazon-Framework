package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class cart {

	public WebDriver driver;
	
	private By cartLabel = By.xpath("//div[@class='a-row sc-your-amazon-cart-is-empty']");
	
	public cart(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public WebElement getCartLabel()
	{
		return driver.findElement(cartLabel);
	}
}
