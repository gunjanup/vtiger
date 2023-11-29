import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ReadDataFromPropertyFiles {
public static WebDriver driver ;


@Test
public void propertyfile() throws IOException
{
		
		
//step 1:open the document in java readable format
FileInputStream fis=new FileInputStream("C:\\Users\\91891\\eclipse-workspace\\AutomationFramework\\src\\test\\resources\\CommonData.properties");	
//step 2:create object of properties class from java.util
Properties pobj=new Properties();
//step 3:load the file input stream to properties class
pobj.load(fis);//to know its a property file as file loads any type of file.
//step 4:provide the key and read the value
String url = pobj.getProperty("url");
System.out.println(url);
String un=pobj.getProperty("username");
System.out.println(un);
String pw=pobj.getProperty("password");
System.out.println(pw);
String Browsername=pobj.getProperty("browser");
if(Browsername.equals("chrome"))
{
	driver=new ChromeDriver();
}
else if(Browsername.equals("edge"))
{
	driver=new ChromeDriver();
}
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
driver.get(url);
driver.findElement(By.name("user_name")).sendKeys(un);
WebElement password=driver.findElement(By.name("user_password"));
password.sendKeys(pw);
WebElement signin=driver.findElement(By.id("submitButton"));
signin.click();
driver.manage().window().minimize();
driver.quit();


	}

}
