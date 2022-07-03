package driverSetupPackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverSetup {
	
	private WebDriver driver;
	
	public DriverSetup(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public WebDriver webDriverIntialization(String browserName)
	{
	
		switch(browserName)
		{
			case "chrome":
				WebDriverManager.chromedriver().setup();
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--disable-notification");
				driver = new ChromeDriver(options);
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				break;
				
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				FirefoxOptions foptions =  new FirefoxOptions();
				foptions.addArguments("--disable-notification");
				driver = new FirefoxDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				break;
				
			case "safari":
				WebDriverManager.safaridriver().setup();
				SafariOptions soptions = new SafariOptions();
				soptions.setCapability("--disable-notifications", true);
				driver = new SafariDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				break;
			default:
				System.out.println("Please enter chrome,firefox or safari brownser name");
				
		}
			
		
		return driver;
	}

}
