package com.vtiger.Campaign;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.crm.VtigerPractice.BaseClass;
import com.crm.VtigerPractice.ExcelUtility;
import com.crm.VtigerPractice.ProperyfileUtilty;
import com.crm.VtigerPractice.WebDriverUtility;
import com.crm.objectrepovtiger.HomePage;
import com.crm.objectrepovtiger.LogOutPage;
import com.crm.objectrepovtiger.LoginPage;
import com.crm.objectrepovtiger.ProductInfopage;
import com.crm.objectrepovtiger.ProductPage;
import com.crm.vtigergenericutils.JavaUtility;

public class CreateProductWithProductCategory {
@Test
public void CreateProduct() throws EncryptedDocumentException, IOException
{
	WebDriver driver = null;
	ProperyfileUtilty plib=new ProperyfileUtilty();
	ExcelUtility elib=new ExcelUtility();
	JavaUtility jlib=new JavaUtility();
	WebDriverUtility wlib=new WebDriverUtility();
   
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
	String EMAIL=plib.readDataFromPropertyfile("username");
	String PASS=plib.readDataFromPropertyfile("password");
	LoginPage lp=new LoginPage(driver);
	lp.login(EMAIL, PASS);
	
	//read data from excel file
	String Productname=elib.readDataFromExcelFile("Sheet1", 1, 0)+jlib.getRandomNumber();
	String ProductCategory=elib.readDataFromExcelFile("Sheet1", 1, 1);
	//launch the browser
	HomePage hp=new HomePage(driver);
	hp.getProducts().click();
	ProductPage pp=new ProductPage(driver);
	pp.getProductimage().click();
	pp.getProductName().sendKeys(Productname);
	pp.getProductCategory().click();
	wlib.handleDropDownbyvalue(pp.getProductCategory(), ProductCategory);
	pp.getSaveButton().click();
	//logout
	ProductInfopage pig=new ProductInfopage(driver);
	String value = pig.getProductHeaderText().getText();
	if(value.contains(Productname))
	{
		System.out.println("product header");
		System.out.println("pass");
	}
	else
	{
		System.out.println("fail");
	}
	//step 8:logout of application
	LogOutPage lo=new LogOutPage(driver);
	 wlib.moveToElement(driver,lo.getLogoutimage());
	lo.getSignout().click();
	 System.out.println("logout success");
	 //step 9:close the browser
	wlib.minimizeWindow(driver);
	wlib.closetheBrowser(driver);
}

}
