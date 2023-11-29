package com.vtiger.signin;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.objectrepovtiger.LogOutPage;
import com.crm.vtigergenericutils.BaseClass;
import com.crm.vtigergenericutils.WebDriverUtils;
@Listeners(com.crm.vtigergenericutils.ListImpClass.class)
public class SigninToTheapplication  extends BaseClass{
	@Test
	public void Signin()
	{
WebDriverUtils wib=new WebDriverUtils();
LogOutPage lp=new LogOutPage(driver);
wib.Action(driver,lp.getLogoutimage());
System.out.println("hello");
	

}
	@Test
	public void signInSucess()
	{
		System.out.println("sign in successful");
	}
}
