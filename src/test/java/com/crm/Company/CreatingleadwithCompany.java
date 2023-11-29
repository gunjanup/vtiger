package com.crm.Company;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.crm.objectrepovtiger.LeadPage;
import com.crm.objectrepovtiger.LogOutPage;
import com.crm.vtigergenericutils.BaseClass;
import com.crm.vtigergenericutils.ExcelFileUtility;
import com.crm.vtigergenericutils.JavaUtility;
import com.crm.vtigergenericutils.WebDriverUtils;

public class CreatingleadwithCompany extends BaseClass {
@Test
public void createlead() throws EncryptedDocumentException, IOException, InterruptedException

{
	JavaUtility jlib=new JavaUtility();
	ExcelFileUtility elib=new ExcelFileUtility();
	WebDriverUtils wlib=new WebDriverUtils();
	//read data from excel file
	
String LastName = elib.readDataFromExcelFile("Sheet1", 1, 2)+jlib.getRandomNumber();
String COMPANY=elib.readDataFromExcelFile("Sheet1", 1, 3);
 

//creating lead
LeadPage lp=new LeadPage(driver);
lp.getLead().click();
lp.getLeadImage().click();
lp.getLastname().sendKeys(LastName);
lp.getCompany().sendKeys(COMPANY);
lp.getSaveButton().click();
String header = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
    if(header.contains(LastName))
    {
   	 System.out.println("lead header");
   	 System.out.println("pass:the last name is"+LastName);
    }
    else
    {
   	 System.out.println("fail the lead header doesnt get created");
    }
LogOutPage lo=new LogOutPage(driver);    
   wlib.Action(driver,lo.getLogoutimage());

   
		
}
}
