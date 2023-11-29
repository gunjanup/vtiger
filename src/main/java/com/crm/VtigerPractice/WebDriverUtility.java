package com.crm.VtigerPractice;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import freemarker.core.JavaScriptOutputFormat;

public class WebDriverUtility {
	
public void maximiseWindow(WebDriver  driver)
{
driver.manage().window().maximize();	
}
public void minimizeWindow(WebDriver driver)
{
driver.manage().window().minimize();	
}
public void fullscreenWindow(WebDriver driver)
{
driver.manage().window().fullscreen();
}
public void closetheBrowser(WebDriver driver)
{
driver.close();	
}
public void implicityTimeOut(WebDriver driver,int seconds)
{
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
}
public void pageloadtimeout(WebDriver driver,int seconds)
{
driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(seconds));
}
public void visiblityofElement(WebDriver driver,int seconds,WebElement element)
{
WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(seconds));
wait.until(ExpectedConditions.visibilityOf(element));
}
public void elementToBeClickable(WebDriver driver,int sec,WebElement element)
{
WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(sec));	
wait.until(ExpectedConditions.elementToBeClickable(element));
}
public void locatorToBeClickable(WebDriver driver,int sec,By locator)
{
WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(sec));
wait.until(ExpectedConditions.elementToBeClickable(locator));
}
public void handleDropDown(WebElement element,int index)
{
Select select=new Select(element);
select.selectByIndex(index);
}
public void handleDropDownbyvalue(WebElement element,String value)
{
Select select=new Select(element);
select.selectByValue(value);
}
public void handleDropDown(WebElement element,String text)
{
Select select=new Select(element);
select.selectByVisibleText(text);
}
public void moveToElement(WebDriver driver,WebElement element)
{
Actions action=new Actions(driver);
action.moveToElement(element).perform();
}
public void rightClick(WebDriver driver,WebElement element)
{
Actions action=new Actions(driver);
action.contextClick().perform();
}
public void rightClickElement(WebDriver driver,WebElement element)
{
Actions action=new Actions(driver);
action.contextClick(element).perform();
}
public void doubleClick(WebDriver driver,WebElement element)
{
Actions action=new Actions(driver);
action.doubleClick().perform();

}
public void doubleclickelement(WebDriver driver,WebElement element)
{
Actions action=new Actions(driver);
action.doubleClick(element).perform();
}
public void draganddrop(WebDriver driver,WebElement element,WebElement src,WebElement target)
{
Actions action=new Actions(driver);
action.dragAndDrop(src, target).perform();
}
public void moveByOFFset(WebDriver driver,WebElement element,int y,int x)
{
Actions action=new Actions(driver);
action.moveByOffset(x, y).perform();
}
public void scrollAction(WebDriver driver)
{
JavascriptExecutor jse=(JavascriptExecutor)	driver;
jse.executeScript("window.ScrollBy(0,500);","");
}
public void scrollActiontoelement(WebDriver driver,WebElement element)
{
JavascriptExecutor jse=(JavascriptExecutor)	driver;
jse.executeScript("arguments[0].scrollIntoView();",element);
}
public void acceptalert(WebDriver driver)
{
driver.switchTo().alert().accept();
}
public void dismissalert(WebDriver driver)
{
driver.switchTo().alert().dismiss();
}
public void sendkeysalert(WebDriver driver,String Text)
{
driver.switchTo().alert().sendKeys(Text);
}
public void getTextalert(WebDriver driver)
{
driver.switchTo().alert().getText();
}
public void switchToFrame(WebDriver driver,int index)
{
driver.switchTo().frame(index);	
}
public void switchToFrameELEMENT(WebDriver driver,WebElement element)
{
driver.switchTo().frame(element);	
}
public void switchToFrameId(WebDriver driver,String id)
{
driver.switchTo().frame(id);
}
public void switchToParentFrame(WebDriver driver)
{
driver.switchTo().parentFrame();
}
public void switchToFrameDefaultContent(WebDriver driver)
{
driver.switchTo().defaultContent();
}
public void switchToWindow(WebDriver driver,String partialWindowid)
{
//capture all window title
 Set<String>   allwinids=driver.getWindowHandles();
 //navigate through each window
for(String id:allwinids)
 {
//switching to each and caturing titles
String acttitle=driver.switchTo().window(id).getTitle();
 //compare title with required
if(acttitle.contains(partialWindowid))
{
	break;
}
}
}
public String takesScreenshot(WebDriver driver,String screenshotName) throws IOException
{
TakesScreenshot tks=(TakesScreenshot)driver;
File src = tks.getScreenshotAs(OutputType.FILE);
File dst =new File(".\\Screenshot\\"+screenshotName+"png");
FileUtils.copyFile(src, dst);
return dst.getAbsolutePath();//used for extent report
}

	// TODO Auto-generated method stub
	
}



