import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.VtigerPractice.ExcelUtility;
import com.crm.VtigerPractice.ProperyfileUtilty;
import com.crm.VtigerPractice.WebDriverUtility;
import com.crm.objectrepovtiger.CampaignInfoPage;
import com.crm.objectrepovtiger.CampaignPage;
import com.crm.objectrepovtiger.HomePage;
import com.crm.objectrepovtiger.LogOutPage;
import com.crm.objectrepovtiger.LoginPage;
import com.crm.vtigergenericutils.JavaUtility;

public class CreateCampaignWithCampaignType {
@Test
public  void createCampaign() throws EncryptedDocumentException, IOException {
    WebDriver driver = null;
    
    		System.out.println("login sucessful");
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
	HomePage hp=new HomePage(driver);
	String campaignname = elib.readDataFromExcelFile("Sheet1", 5, 0);
	String campaigntype=elib.readDataFromExcelFile("Sheet1", 5, 1);
	hp.getMore().click();
	hp.getCampaign().click();
	CampaignPage cp=new CampaignPage(driver);
	cp.getCampaignimage().click();
	cp.getCampaignName().sendKeys(campaignname);
	cp.getCampaignType().click();
	wlib.handleDropDownbyvalue(cp.getCampaignType(), campaigntype);
	cp.getSavebutton().click();
CampaignInfoPage cif=new CampaignInfoPage(driver);
 String value=cif.getCampaignHeaderText().getText();
 SoftAssert sa=new SoftAssert();
 sa.assertEquals(value,campaignname);
 System.out.println("Campaign created Successfully");

	//logout to application
LogOutPage lo=new LogOutPage(driver);
wlib.moveToElement(driver,lo.getLogoutimage());
lo.getSignout().click();
wlib.minimizeWindow(driver);
wlib.closetheBrowser(driver);
	
	
	
	
		
	}
}

