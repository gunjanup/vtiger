package com.crm.objectrepovtiger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogOutPage {
  @FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
  private WebElement logoutimage;
  
  @FindBy(xpath="//a[.='Sign Out']")
  private WebElement signout;
  
  public LogOutPage(WebDriver driver)
  {
	  PageFactory.initElements(driver,this);
  }


public WebElement getLogoutimage() {
	return logoutimage;
}

public WebElement getSignout() {
	return signout;
}
  
public void logout()
{
	signout.click();
}
  
}
