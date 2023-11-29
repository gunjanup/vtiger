import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
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

public class CreateProductWithProductTypewithDataProvider  {
WebDriver driver=null;
ProperyfileUtilty plib=new ProperyfileUtilty();
ExcelUtility elib=new ExcelUtility();
JavaUtility jlib=new JavaUtility();
WebDriverUtility wlib=new WebDriverUtility();
	
@Test(dataProvider = "getdata")
public void createmultipleProductdata(String Productna,String ProductCategory) throws IOException, InterruptedException
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
		String EMAIL=plib.readDataFromPropertyfile("username");
		String PASS=plib.readDataFromPropertyfile("password");
		LoginPage lp=new LoginPage(driver);
		lp.login(EMAIL, PASS);
		System.out.println("login sucessful");
System.out.println(Productna+"-----"+ProductCategory);
String Productname=Productna+jlib.getRandomNumber();
	
	

	//step 3:navigate to products link
	HomePage hp=new HomePage(driver);
	hp.getProducts().click();
	//step 4:click on product  image
	ProductPage pp=new ProductPage(driver);
	pp.getProductimage().click();
	//step 5:create product with mandatory fields
	pp.getProductName().sendKeys(Productname);
	//step 6:select product in the product category dropdown
	pp.getProductCategory().click();
	wlib.handleDropDownbyvalue(pp.getProductCategory(), ProductCategory);
	//step 7:save
	pp.getSaveButton().click();

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
	 Thread.sleep(1000);
	 lo.getSignout();
	 System.out.println("logout success");
	 //step 9:close the browser
	 wlib.minimizeWindow(driver);
	 wlib.closetheBrowser(driver);
}
  @DataProvider
	public  Object[][] getdata() throws EncryptedDocumentException, IOException
	{
	Object[][] data=elib.readmultipleDataFromExcel("Sheet1");
	return data;
	}
}
