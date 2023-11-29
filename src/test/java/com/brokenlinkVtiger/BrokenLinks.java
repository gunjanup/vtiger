package com.brokenlinkVtiger;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
WebDriver driver=new ChromeDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
driver.get("https://www.instagram.com/");
List<WebElement> links = driver.findElements(By.tagName("a"));
System.out.println("no of links in application is"+links.size());
//maintain list of string for iterating one by one link
List<String> urlist=new ArrayList<String>();
for(WebElement e:links)
{
	String url=e.getAttribute("href");
	checkBrokenlinks(url);
}
driver.quit();
	}
	
public static void checkBrokenlinks(String linkurl) throws MalformedURLException {
	try{
		URL url=new URL(linkurl);
	HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
	httpURLConnection.setConnectTimeout(5000);
	httpURLConnection.connect();
	if(httpURLConnection.getResponseCode()>=400)
	{
	System.out.println(linkurl+"---"+httpURLConnection.getResponseMessage()+"is a broken link");	
	}
	else
	{
		System.out.println(linkurl+"---"+httpURLConnection.getResponseMessage());
	}
	}
	catch (Exception e) {
		// TODO: handle exception
	}
	
}

}
