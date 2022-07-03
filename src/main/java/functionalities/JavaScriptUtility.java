package functionalities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class JavaScriptUtility {
	private WebDriver driver;
	private JavascriptExecutor js;
	
	public JavaScriptUtility(WebDriver driver)
	{
		this.driver = driver;
	}
	public void windowScrollDown(int xOffset, int yOffset)
	{
		String key = "window.scrollBy("+xOffset+","+yOffset+")";
		js = (JavascriptExecutor) driver;
	    js.executeScript(key, "");
	}
}
