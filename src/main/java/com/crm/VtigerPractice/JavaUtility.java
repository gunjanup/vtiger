package com.crm.VtigerPractice;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Random;

public class JavaUtility {
/**This class consists of reusable method of java utility
 * @return 
 * 
 */
	public int randomNo()
	{
		Random r=new Random();
		int random = r.nextInt();
		return random;
	}
	public String getSystemdate()
	{
		java.util.Date date=new java.util.Date();
		SimpleDateFormat formatter=new SimpleDateFormat("dd-MM-yyyy hh-mm-ss");
	     String data = formatter.format(date);
	     return data;
	}
	
	public String getdate()
	{
		java.util.Date date=new java.util.Date();
		String value = date.toString();
		return value;
	}
}
