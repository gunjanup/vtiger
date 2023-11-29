package com.crm.vtigergenericutils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**This class consists of re-usable methods related to java
 * @author gunjan 
 */
public class JavaUtility {
	/**
	 * this method will return a random number for every execution
	 * @return
	 */
	public int getRandomNumber()
	{
		Random ran=new Random();
		return ran.nextInt(1000);
	}
/**This method will generate the current system date in specified format
 * @return 
 *	
 */
	public String getSystemDate()
	{
	Date d=new Date();
	 String  date= d.toString();
	return date;
	}
	
	public String systemDataInFormat()
	{
		SimpleDateFormat dateformat=new SimpleDateFormat("dd/MM/yyyy HH-mm-ss");
		Date date=new Date();
		String systemDataInFormat=dateformat.format(date);
		return systemDataInFormat;
		
		
	}


}
