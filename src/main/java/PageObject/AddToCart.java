package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddToCart {

	public WebDriver driver;
	
	private By addToCart = By.id("add-to-cart-button");
	private By cartDetails = By.xpath("//div[@class='a-box-inner']/div[1]/div[2]/div[1]");
	
	public AddToCart(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public WebElement getAddToCart()
	{
		return driver.findElement(addToCart);
	}
	
	public WebElement getCartDetails()
	{
		return driver.findElement(cartDetails);
	}
	
}
