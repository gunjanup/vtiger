package com.crm.objectrepovtiger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadPage {
@FindBy(linkText = "Leads")
private WebElement lead;

@FindBy(xpath = "//img[@alt='Create Lead...']")
private WebElement LeadImage;

@FindBy(xpath="//input[@name='lastname']")
private WebElement lastname;

@FindBy(xpath="//input[@name='company']")
private WebElement company;

@FindBy(name="leadsource")
private WebElement leadsource;

@FindBy(name = "industry")
private WebElement industry;

@FindBy(name="leadstatus")
private WebElement leadStatus;


@FindBy(xpath="//input[@title=\"Save [Alt+S]\"]")
private WebElement SaveButton;



//initialization
public  LeadPage(WebDriver driver)
{
PageFactory.initElements( driver,this);	
}

public WebElement getLead() {
	return lead;
}

public WebElement getLeadImage() {
	return LeadImage;
}

public WebElement getLastname() {
	return lastname;
}

public WebElement getCompany() {
	return company;
}

public WebElement getLeadsource() {
	return leadsource;
}

public WebElement getIndustry() {
	return industry;
}

public WebElement getLeadStatus() {
	return leadStatus;
}

public WebElement getSaveButton() {
	return SaveButton;
}

//buisness logic
public void LeadPage(String last,String com)
{
lead.click();
LeadImage.click();
lastname.sendKeys(last);
company.sendKeys(com);

SaveButton.click();





}

}
