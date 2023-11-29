package com.crm.VtigerPractice;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ItestListenerimp implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
String	methodname=result.getMethod().getMethodName();
System.out.println(methodname+"test script execution started");
	}

	@Override
public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
String methodname = result.getMethod().getMethodName();
System.out.println(methodname+"--test success");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
	WebDriverUtility wlib=new WebDriverUtility();
	JavaUtility jlib=new JavaUtility();
	System.out.println(	result.getThrowable());
  String methodname = result.getMethod().getMethodName();
  String Screenshotname=methodname+jlib.getSystemdate();
		try {
			wlib.takesScreenshot(BaseClass.sdriver, Screenshotname);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(methodname+"--test failure");	
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
	    result.getThrowable();
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname+"--test skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		 result.getThrowable();
			String methodname = result.getMethod().getMethodName();
			System.out.println(methodname+"--test failed");	
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		 result.getThrowable();
			String methodname = result.getMethod().getMethodName();
			System.out.println(methodname+"--test failed");	
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		 	
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
	

}
