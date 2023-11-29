package com.crm.vtigergenericutils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/**
 * This class contains Generic/reusable Methods related to property files
 * @author gunjan
 */
public class FileUtils {
/**
 * This method will read data from property file and returns the value to the caller	
 * @param key
 * @return
 * @throws IOException
 */
public String readDataFromPropertiesFiles(String key) throws IOException
{
FileInputStream fis=new FileInputStream(IPathConstants.Filepath);
Properties p=new Properties();
p.load(fis);
String value = p.getProperty(key);
return value;

}

}
