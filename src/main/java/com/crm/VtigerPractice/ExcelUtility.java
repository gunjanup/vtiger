package com.crm.VtigerPractice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**This class consist of all reusable method related to excel utilty
 * 
 */
public class ExcelUtility {
/**This method read data from excel file and return value to the caller
 * 
 * @param Sheet
 * @param row
 * @param cell
 * @return
 * @throws EncryptedDocumentException
 * @throws IOException
 */
	
public String readDataFromExcelFile(String Sheet,int row,int cell) throws EncryptedDocumentException, IOException
{
FileInputStream fi=new FileInputStream(IpathConstantsClass.Excelorgpath);
Workbook wb = WorkbookFactory.create(fi);
org.apache.poi.ss.usermodel.Sheet sh = wb.getSheet(Sheet);
String data = sh.getRow(row).getCell(cell).getStringCellValue();
wb.close();
return data;
}
/**This method is used to write data from excel file
 * 
 * @param value
 * @param sheet
 * @param row
 * @param cell
 * @throws EncryptedDocumentException
 * @throws IOException
 */

public void writedatafromExcelfile(String sheet,int row,int cell,String value) throws EncryptedDocumentException, IOException
{
	FileInputStream fi=new FileInputStream(IpathConstantsClass.Excelorgpath);
	Workbook wb = WorkbookFactory.create(fi);
	wb.createSheet(sheet).createRow(row).createCell(cell).setCellValue(value);
	FileOutputStream fos=new FileOutputStream(IpathConstantsClass.Excelorgpath);
	wb.write(fos);
	wb.close();

}

public int getlastrow(String Sheet) throws EncryptedDocumentException, IOException
{
	FileInputStream fi=new FileInputStream(IpathConstantsClass.Excelorgpath);
	Workbook wb = WorkbookFactory.create(fi);	
	int count = wb.getSheet(Sheet).getLastRowNum();
	return count;
}

public Object[][] readmultipleDataFromExcel(String sheet) throws EncryptedDocumentException, IOException
{
	FileInputStream fi=new FileInputStream(".\\src\\test\\resources\\dataprovider.xlsx");
	Workbook wb = WorkbookFactory.create(fi);
	Sheet sh = wb.getSheet(sheet);
	int row = sh.getLastRowNum();
	int cell=sh.getRow(0).getLastCellNum();
	Object[][] data=new Object[row][cell];
	
	for(int i=0;i<row;i++)
	{
	for(int j=0;j<cell;j++)
	{
	data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();	
	}
	}
	return data;
}
}
