import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import io.netty.handler.codec.http.HttpChunkedInput;

public class VtigerBrokenLinkTest {
@Test
	public  void brokenlink() throws IOException {
		// TODO Auto-generated method stub
WebDriver driver=new EdgeDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
driver.get("https://www.goibibo.com/");
List<WebElement> Alllinks = driver.findElements(By.tagName("a"));
System.out.println(Alllinks.size());
ArrayList<String> arrlinks=new ArrayList<String>();
for(int i=0;i<Alllinks.size();i++)
{
	String eachlink=Alllinks.get(i).getAttribute("href");
	URL url=null;
	int statuscode=0;
	try
	{
		 url=new URL(eachlink);
		 HttpsURLConnection httpurlconn=(HttpsURLConnection)url.openConnection();
		 statuscode=httpurlconn.getResponseCode();
	if(statuscode>=400)
	{
		arrlinks.add(eachlink);
		System.out.println(eachlink+"----"+statuscode);
	}
	}
	catch (MalformedURLException e) {
		// TODO: handle exception
		System.out.println(eachlink+"----"+statuscode);
	}
}

	}

}
