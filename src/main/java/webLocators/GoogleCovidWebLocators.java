package webLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleCovidWebLocators {
	
	private WebDriver driver;
	private By svgLocator = By.xpath("(//*[local-name()='svg'][@class='uch-psvg'])[1]");
	private By toolTipLocator = By.xpath("//*[@class='ExnoTd']"); 
	
	public GoogleCovidWebLocators(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public WebElement getGraphicalAxis()
	{
		return driver.findElement(svgLocator);
	}
	
	public WebElement getToolTipData()
	{
		return driver.findElement(toolTipLocator);
	}

}
