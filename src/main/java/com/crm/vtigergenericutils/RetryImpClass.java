package com.crm.vtigergenericutils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryImpClass  implements IRetryAnalyzer{
   
   
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		int count=0;
		int limitRetry=3;
		if(count<limitRetry)
		{
			count++;
			return true;
		}
		return false;
	}

}

