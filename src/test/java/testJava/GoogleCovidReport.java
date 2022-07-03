package testJava;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import driverSetupPackage.DriverSetup;
import functionalities.HandleSVG;
public class GoogleCovidReport{


	private WebDriver driver;
	private FileInputStream fis;
	private Properties prop;
	private String url="";
	
	@BeforeTest
	public void testConfiguration() throws IOException
	{
		fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\testResources\\configuration.properties");
		prop = new Properties();
		prop.load(fis);
		url = prop.getProperty("url");
		String browserName = prop.getProperty("browser");
		DriverSetup ds = new DriverSetup(driver);
		driver = ds.webDriverIntialization(browserName);	
		driver.get(url);
	}
	
	@Test
	public void validateCovidGraph() throws ParseException, IOException, InterruptedException
	{
		
		HandleSVG hsvg = new HandleSVG(driver);
		hsvg.traverseSVGGraph();
 	}
	
	@AfterTest
	public void afterTest()
	{
		driver.close();
	}
	

}
