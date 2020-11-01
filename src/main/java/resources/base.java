package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class base {

	public WebDriver driver;
	public Properties properties;
	public WebDriver initializeDriver() throws IOException
	{
		properties = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
		
		properties.load(fis);
		
		//To run through command line and provide browser info through command line
		//remove comment of below statement, command :- mvn test -Dbrowser=chrome
		//String browser = System.getProperty("browser"); 
		
		//To provide browser info through properties file
		String browser = properties.getProperty("browser");
		
		if(browser.contains("chrome"))
		{
			String chromePath = System.getProperty("user.dir")+"\\src\\main\\java\\resources\\BrowserDrivers\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", chromePath);
			ChromeOptions options = new ChromeOptions();
			if(browser.contains("chromeheadless"))
			{
			options.addArguments("headless");
			}
			driver = new ChromeDriver(options);
			
		}
		
		else if(browser.equalsIgnoreCase("firefox"))
		{
			String fireFoxPath = System.getProperty("user.dir")+"\\src\\main\\java\\resources\\BrowserDrivers\\geckodriver.exe";
			System.setProperty("webdriver.gecko.driver", fireFoxPath);
			driver = new FirefoxDriver();
			
		}
		
		else if(browser.equalsIgnoreCase("IE"))
		{
			String IEPath = System.getProperty("user.dir")+"\\src\\main\\java\\resources\\BrowserDrivers\\IEDriverServer.exe";
			System.setProperty("webdriver.ie.driver", IEPath);
			driver = new InternetExplorerDriver();
			
		}
		driver.manage().timeouts().implicitlyWait(25,TimeUnit.SECONDS);
		return driver;
	}
	
	public String getScreenshotPath(String testCaseName, WebDriver driver) throws IOException
	{
		TakesScreenshot TS =(TakesScreenshot) driver;
		File source = TS.getScreenshotAs(OutputType.FILE);
		String DestinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		FileUtils.copyFile(source, new File(DestinationFile));
		return DestinationFile;
		
	}
}
