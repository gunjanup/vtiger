package com.crm.objectrepovtiger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

	@FindBy(xpath = "//img[@alt=\"Create Product...\"]")
	private WebElement productimage;
	
	@FindBy(name = "productname")
	private WebElement productName;
	
	@FindBy(name ="productcategory")
	private WebElement productCategory;

	@FindBy(xpath = "//input[@title=\"Save [Alt+S]\"]")
	private WebElement saveButton;

	public WebElement getProductimage() {
		return productimage;
	}

	public WebElement getProductName() {
		return productName;
	}

	public WebElement getProductCategory() {
		return productCategory;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	public ProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	public void Product(String name)
	{
		productimage.click();
		productName.sendKeys(name);
		productCategory.click();
		saveButton.click();
		
		
		
	}
	
}
