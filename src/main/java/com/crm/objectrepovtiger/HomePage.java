package com.crm.objectrepovtiger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	
@FindBy(xpath="//a[.='Campaigns']")
private WebElement Campaign;
@FindBy(xpath ="//a[.='More']")
private WebElement more;
@FindBy(linkText = "Products")
private WebElement Products;

public HomePage(WebDriver driver)
{
	PageFactory.initElements( driver,this);
}

public WebElement getCampaign() {
	return Campaign;
}

	
	
public WebElement getMore() {
	return more;
}

public WebElement getProducts() {
	return Products;
}

public void HomeOperation()
{
Campaign.click();	
more.click();
Products.click();

}
}

