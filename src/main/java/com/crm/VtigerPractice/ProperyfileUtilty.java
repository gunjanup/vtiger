package com.crm.VtigerPractice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
/**This class consists of Generic methods related to property file
 * @author gunjan
 * 
 *
 */
public class ProperyfileUtilty {
/**This method will read data from property file and return value to the caller
 * 
 * @param key
 * @return
 * @throws IOException 
 * @throws 
 */
public String readDataFromPropertyfile(String key) throws IOException 
{
//open file in readable format
FileInputStream fis=new FileInputStream(IpathConstantsClass.Fileorgpath);
Properties pobj=new Properties();
pobj.load(fis);
String value = pobj.getProperty(key);
return value;
	}
	
}
