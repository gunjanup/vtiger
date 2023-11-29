package com.crm.objectrepovtiger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignInfoPage {

	@FindBy(xpath ="//span[@class='dvHeaderText']")
	private WebElement CampaignHeaderText;

	public WebElement getCampaignHeaderText() {
		return CampaignHeaderText;
	}
	
public CampaignInfoPage(WebDriver driver)
{
PageFactory.initElements(driver,this);	
}
public String Campaign()
{
	return CampaignHeaderText.getText();	
}
}
