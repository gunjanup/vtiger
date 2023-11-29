package com.crm.vtigergenericutils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
/**This class contains all webdriver specific generic and reusable methods
 * 
 */
public class WebDriverUtils {
/*This method is used to maximize the window of the browser
 * 
 */
	public void maximizeBrowser(WebDriver driver)
	{
	driver.manage().window().maximize();	
	}
	/*This method is used to put implicity wait time conditions
	 * 
	 */
	
	public void implicitlywait(WebDriver driver,int seconds)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
	}
	/*This method is used to close the browser
	 * 
	 */
	
	public void closeBrowser(WebDriver driver)
	{
		driver.close();
	}
	/*This method is used to move specific element by using actions class
	 * 
	 */
	public void Action(WebDriver driver,WebElement element)
	{
		Actions action=new Actions(driver);
		action.moveToElement(element).perform();
	}
	/*This method is used to take Screenshot of particular element
	 * 
	 */
	public static String getScreenshot(WebDriver driver,String Screenshot) throws IOException
	{
	TakesScreenshot ts=(TakesScreenshot)driver;
	File Src=ts.getScreenshotAs(OutputType.FILE);
	String path="./Screenshot"+Screenshot+".png";
	File dst=new File(path);
	FileUtils.copyFile(Src, dst);
	return path;
	}
	/*This method is used to select element for dropdown purpose
	 * 
	 * 
	 */
	public void selectByText(WebElement element,String text)
	{
	Select select=new Select(element);
	select.selectByVisibleText(text);
	}
	 /*This method is used to select element by using Index
	  * 
	  * 
	  */
	public void selectByIndex(WebElement element,int index)
	{
		Select select=new Select(element);
		select.selectByIndex(index);
	}
	/*This method is used to select element by using value
	 * 
	 * 
	 */
	public void selectByValue(WebElement element,String Value)
	{
		Select select=new Select(element);
		select.selectByValue(Value);
	}
	/*This method is used to perform Action
	 * 
	 */
	public  void actionmove(WebDriver driver,WebElement element)
	{
	Actions action=new Actions(driver);
	action.moveToElement(element).perform();
	}
	}

