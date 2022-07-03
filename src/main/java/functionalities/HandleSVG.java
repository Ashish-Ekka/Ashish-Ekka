package functionalities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import webLocators.GoogleCovidWebLocators;

public class HandleSVG {

private WebDriver driver;

private FileInputStream fis;
private Actions action;
private ArrayList covidDataList;

	public HandleSVG(WebDriver driver)
	{
		this.driver = driver;
	}

	public void traverseSVGGraph() throws ParseException, IOException, InterruptedException
	{
		//String result = "";
		 boolean report= false;
		// created locator class object
		GoogleCovidWebLocators gLocator = new GoogleCovidWebLocators(driver);
		
		//initiated FileInputStream object by providing path of the configuration.properties file
		fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\mainResources\\dataConfiguration.properties");
		Properties prop = new Properties();
		prop.load(fis);
		fis.close();
		//fetching date from configuration.properties file
		String startDate = prop.getProperty("date");
		
		//Created JavaScriptUtility class object to scroll down window
		JavaScriptUtility jsu = new JavaScriptUtility(driver);
		jsu.windowScrollDown(0, 350);
		
		//getting the top left Y axis position of the graph
		int getTopLeftY = ((gLocator.getGraphicalAxis().getSize().getHeight())/2) - (gLocator.getGraphicalAxis().getSize().getHeight());
		//getting the top left X axis position of the graph
		int getTopLeftX = ((gLocator.getGraphicalAxis().getSize().getWidth())/2) - (gLocator.getGraphicalAxis().getSize().getWidth());
	
		action = new Actions(driver);
	
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-YYYY");
		Date d1 = sdf.parse(startDate);
		Date d2 = new Date();
		//calculating the no. of days from starting date of data available to till date.
		long diffINDate = TimeUnit.MILLISECONDS.toDays(d2.getTime()-d1.getTime());
		
		Properties prop1 = new Properties();
		//traversing the graph from start date to till date
		for(int i=0;i<10;i++)
		{
			action.moveToElement(gLocator.getGraphicalAxis(),getTopLeftX+i,getTopLeftY).build().perform();
			Thread.sleep(3000);
			String data = gLocator.getToolTipData().getText();
			
			FileOutputStream fos = new FileOutputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\mainResources\\storeData.properties");
			prop1.setProperty("CovidCases"+(i+1), data);
			prop1.store(fos, null);
			
		}
	}
	
	public void validateCovidData() throws ParseException, IOException
	{
		Properties prop2 = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\mainResources\\storeData.properties");
	}
	
	
}
