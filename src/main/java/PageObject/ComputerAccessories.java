package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ComputerAccessories {

	public WebDriver driver;
	
	private By product = By.xpath("//div[@id='search-results']/div[2]/ul/li[1]/div/div[3]");
	
	public ComputerAccessories(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public AddToCart getProduct()
	{
		driver.findElement(product).click();
		AddToCart ATD = new AddToCart(driver);
		return ATD;
	}
	
}
