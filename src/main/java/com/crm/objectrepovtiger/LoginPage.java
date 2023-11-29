package com.crm.objectrepovtiger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	//declaration
@FindBy(xpath = "//input[@name='user_name']")
private WebElement emailid;

@FindBy(xpath ="//input[@name='user_password']")
private WebElement password;

@FindBy(xpath = "//input[@id='submitButton']")
private WebElement submitButton;


//initialization 
public LoginPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
public WebElement getEmail() {
	return emailid;
}

public WebElement getPassword() {
	return password;
}

public WebElement getSubmitButton() {
	return submitButton;
}
//buisness logic
public void login(String USERNAME,String PASSWORD)
{
	emailid.sendKeys("admin");
	password.sendKeys("admin");
	submitButton.click();
}


}
