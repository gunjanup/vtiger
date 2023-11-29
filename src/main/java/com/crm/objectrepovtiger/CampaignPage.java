package com.crm.objectrepovtiger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignPage {
	
	@FindBy(xpath = "//img[@alt=\"Create Campaign...\"]")
	private WebElement Campaignimage;
	@FindBy(name = "campaignname")
	private WebElement CampaignName;
	@FindBy(xpath = "//select[@name='campaigntype']")
	private WebElement CampaignType;
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement savebutton;
	
	public CampaignPage(WebDriver driver)
	{
		PageFactory.initElements( driver,this);
	}


	public WebElement getCampaignimage() {
		return Campaignimage;
	}
	
	public WebElement getCampaignName() {
		return CampaignName;
	}
	
	public WebElement getCampaignType() {
		return CampaignType;
	}
	


	public WebElement getSavebutton() {
		return savebutton;
	}


	public void Campaign(String name)
	{
		Campaignimage.click();
		CampaignName.sendKeys(name);
		CampaignType.click();
		savebutton.click();
	}


	

}
