package com.crm.Company;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
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
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.crm.objectrepovtiger.LeadPage;
import com.crm.objectrepovtiger.LogOutPage;
import com.crm.vtigergenericutils.ExcelFileUtility;
import com.crm.vtigergenericutils.JavaUtility;
import com.crm.vtigergenericutils.WebDriverUtils;

public class CreateleadwithCompanyWithrRequiredDetails {
	@Test
public void createleadwithRequireddetails() throws EncryptedDocumentException, IOException, InterruptedException

	{
		JavaUtility jlib=new JavaUtility();
		ExcelFileUtility elib=new ExcelFileUtility();
		WebDriverUtils wlib=new WebDriverUtils();
		//read data from excel file
		
	String LastName = elib.readDataFromExcelFile("Sheet1", 6, 1);
	String COMPANY=elib.readDataFromExcelFile("Sheet1", 6, 2);
	String LeadSource=elib.readDataFromExcelFile("Sheet1", 6, 3);
	String Industry=elib.readDataFromExcelFile("Sheet1", 6, 5);
	String LeadStatus=elib.readDataFromExcelFile("Sheet1", 6, 6);
	 

	//creating lead
	
	WebDriver driver = null;
	LeadPage lp=new LeadPage(driver);
	lp.getLead().click();
	lp.getLeadImage().click();
	lp.getLastname().sendKeys(LastName);
	lp.getCompany().sendKeys(COMPANY);
	lp.getLeadsource();
	wlib.selectByText(lp.getLeadsource(), LeadSource);
	lp.getIndustry();
	wlib.selectByText(lp.getIndustry(),Industry);
	lp.getLeadStatus();
	wlib.selectByText(lp.getLeadStatus(), LeadStatus);
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