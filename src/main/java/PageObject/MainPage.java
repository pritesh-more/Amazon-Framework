package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {

	public WebDriver driver;
	private By label = By.xpath("//div[@id='nav-xshop']/a[1]");
	private By moveSignIn = By.id("nav-link-accountList");
	private By signIn = By.xpath("//span[text()='Sign in']");
	private By CA = By.xpath("//a[@class='a-link-normal quadrant-overlay']");
	private By cart = By.id("nav-cart");
	
	public MainPage(WebDriver driver)
	{
		this.driver = driver;
	}

	public WebElement getLabel()
	{
		return driver.findElement(label);
	}
	
	public WebElement getCursorOnSignIn()
	{
		return driver.findElement(moveSignIn);
	}
	
	public SignIn getSignIn()
	{
		driver.findElement(signIn).click();
		SignIn SI = new SignIn(driver);
		return SI;
	}
	
	public ComputerAccessories getCA()
	{
		driver.findElement(CA).click();
		ComputerAccessories CA = new ComputerAccessories(driver);
		return CA;
	}
	
	public cart getCart()
	{
		driver.findElement(cart).click();
		cart c = new cart(driver);
		return c;
	}
	
}
