package com.crm.VtigerPractice;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.crm.objectrepovtiger.LogOutPage;
import com.crm.objectrepovtiger.LoginPage;
import com.crm.vtigergenericutils.JavaUtility;

public class BaseClass {
	WebDriverUtility driver;
public	ProperyfileUtilty plib=new ProperyfileUtilty();
public 	ExcelUtility elib=new ExcelUtility();
public 	JavaUtility jlib=new JavaUtility();
public	WebDriverUtility wlib=new WebDriverUtility();
public static WebDriverUtility sdriver;

@BeforeSuite
public void bsConfig() {
	System.out.println("connection established");
}
@BeforeClass
public void bcConfig() throws IOException
{
	String BROWSER=plib.readDataFromPropertyfile("browser");
	String URL=plib.readDataFromPropertyfile("url");
	if(BROWSER.equalsIgnoreCase("chrome"))
	{
	 driver=new ChromeDriver();
	}
	else if (BROWSER.equalsIgnoreCase("firefox")) {
	driver=new FirefoxDriver();
	}

	wlib.maximiseWindow(driver);
	wlib.implicityTimeOut(driver, 3);
	driver.get(URL);
	sdriver=driver;
}
@BeforeMethod
public void bmConfig() throws IOException
{
	String EMAIL=plib.readDataFromPropertyfile("username");
	String PASS=plib.readDataFromPropertyfile("password");
	LoginPage lp=new LoginPage(driver);
	lp.login(EMAIL, PASS);
	System.out.println("login sucessful");
}


@AfterMethod
public void afCnfig() throws InterruptedException
{
	LogOutPage lo=new LogOutPage(driver);
	wlib.moveToElement(driver,lo.getLogoutimage());
	Thread.sleep(1000);
	lo.getSignout();
	 System.out.println("logout success");
}

@AfterClass
public void acConfig()
{
	wlib.minimizeWindow(driver);
	wlib.closetheBrowser(driver);
}
@AfterSuite()
public void asConfig()

{
System.out.println("connectionn close");	
}
}
