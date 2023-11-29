package com.crm.vtigergenericutils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**This class consists of Generic/reusable method related to excel utils
 * @author gunjan
 * @throws IOException 
 * @throws EncryptedDocumentException 
 */
public class ExcelFileUtility {

	
/**
 * This method will read from excel sheet and return value to the caller
 * @param Sheet
 * @param row
 * @param cellno
 * @return 
 * @throws EncryptedDocumentException
 * @throws IOException
 */
public String readDataFromExcelFile(String Sheet,int row,int cellno) throws EncryptedDocumentException, IOException
{
FileInputStream fis=new FileInputStream(IPathConstants.Excelpath);
Workbook workbook = WorkbookFactory.create(fis);
org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheet(Sheet);
String data = sheet.getRow(row).getCell(cellno).getStringCellValue();
workbook.close();
return data;
}
/**This method will write from excel sheet 
 * 
 * @param Sheet
 * @param row
 * @param cellno
 * @param value
 * @throws EncryptedDocumentException
 * @throws IOException
 */
public void writeDataIntoExcel(String Sheet,int row,int cellno,String value) throws EncryptedDocumentException, IOException
{
	FileInputStream fis=new FileInputStream(IPathConstants.Excelpath);
	Workbook workbook = WorkbookFactory.create(fis);
	org.apache.poi.ss.usermodel.Sheet sheet = workbook.createSheet(Sheet);
	sheet.createRow(row).createCell(cellno).setCellValue(value);
	FileOutputStream fos=new FileOutputStream(".\\src\\test\\resources\\lead.xlsx");
	workbook.write(fos);
	workbook.close();
		
	
}

}
