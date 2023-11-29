import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import ObjectRepository.LoginPage;

public class Vtiger1stScenario {

public static void main(String[] args) throws InterruptedException {
//step1: launch the browser
WebDriver driver=new ChromeDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
driver.get("http://localhost:8888/index.php?action=Login&module=Users");
//step2: login to application
WebElement emailid=driver.findElement(By.name("user_name"));
emailid.sendKeys("admin");
WebElement password=driver.findElement(By.name("user_password"));
password.sendKeys("admin");
WebElement signin=driver.findElement(By.id("submitButton"));
signin.click();


//step3:  navigate to contact link
WebElement contact=driver.findElement(By.xpath("//a[.='Contacts']"));
contact.click();
//step 4:Click on Create Account image up 
WebElement imglookup=driver.findElement(By.xpath("//img[@title='Create Contact...']"));
imglookup.click();
//step 5:create contact list with mandatory fields
WebElement lastname=driver.findElement(By.name("lastname"));
lastname.sendKeys("himalayan");
//step 6:click on save
driver.findElement(By.xpath("//input[contains(@class,'crmbutton small save')]")).click();
//step 7:validate
 String header = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
 if(header.contains("himalayan"))
 {
	 System.out.println("contact header");
	 System.out.println("pass");
 }
 else
 {
	 System.out.println("fail");
 }
 //step 8:logout of application
 WebElement logout=driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
 Actions act=new Actions(driver);
 Thread.sleep(1000);
 act.moveToElement(logout).perform();
 Thread.sleep(1000);
 driver.findElement(By.linkText("Sign Out")).click();
 System.out.println("logout success");
 //step 9:close the browser
 driver.manage().window().minimize();
 driver.quit();
	}

}
