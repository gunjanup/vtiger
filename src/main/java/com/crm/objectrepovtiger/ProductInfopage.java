package com.crm.objectrepovtiger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductInfopage {
	@FindBy(xpath = "//span[@class=\"lvtHeaderText\"]")
	private WebElement productHeaderText;

	public WebElement getProductHeaderText() {
		return productHeaderText;
	}
	
	public ProductInfopage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	public String Product(String name)
	{
		return productHeaderText.getText();
		
		
	}

}
