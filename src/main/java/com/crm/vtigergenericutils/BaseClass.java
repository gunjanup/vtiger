package com.crm.vtigergenericutils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.crm.objectrepovtiger.LogOutPage;
import com.crm.objectrepovtiger.LoginPage;




public class BaseClass {

	
FileUtils fib=new FileUtils();
WebDriverUtils wib=new WebDriverUtils();
protected static WebDriver driver;
public static WebDriver sdriver;
@Parameters("browser")
@BeforeClass
public void config_BeforeClass(String browser) throws IOException
{
//String browser=fib.readDataFromPropertiesFiles("browser");
if(browser.equalsIgnoreCase("chrome"))
{
	driver=new ChromeDriver();
	
}
else if (browser.equalsIgnoreCase("firefox")) {
	driver=new FirefoxDriver();
}
else if(browser.equalsIgnoreCase("edge"))
{
	driver=new EdgeDriver();
}
else
{
	System.out.println("no browser launch");
}
sdriver=driver;
wib.maximizeBrowser(driver);
wib.implicitlywait(driver, 10);

}
@BeforeMethod
public void config_BeforeMethod() throws IOException
{

	
	String URL=fib.readDataFromPropertiesFiles("url");
	String BROWSER=fib.readDataFromPropertiesFiles("browser");
	String USERNAME=fib.readDataFromPropertiesFiles("email");
	String PASSWORD=fib.readDataFromPropertiesFiles("password");
	driver.get(URL);
	LoginPage lp=new LoginPage(driver);
	lp.login(USERNAME, PASSWORD);

	
	
	
}
@AfterMethod
public void configureafterMethod()
{
	LogOutPage lp=new LogOutPage(driver);
	lp.getLogoutimage();
	lp.getSignout();
}
@AfterClass
public void closetheBrowser()
{
	wib.closeBrowser(driver);
}

}
