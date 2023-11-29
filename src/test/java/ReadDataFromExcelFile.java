import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class ReadDataFromExcelFile {

@Test
public void excelreading() throws EncryptedDocumentException, IOException{
		// TODO Auto-generated method stub
//1.open the document in java readable mode
FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\lead.xlsx");

//2.create a workbook
Workbook workbook = WorkbookFactory.create(fis);
//3.navigate to required sheet
Sheet sh = workbook.getSheet("Sheet1");

//4.Navigate to required row
Row row = sh.getRow(1);
//5.navigate to required cell
Cell cell = row.getCell(3);
//read the data inside the cell
String data = cell.getStringCellValue();
String LastName=sh.getRow(6).getCell(2).getStringCellValue();
System.out.println(LastName);
String COMPANY=sh.getRow(6).getCell(3).getStringCellValue();
System.out.println(COMPANY);
String LeadSource=sh.getRow(6).getCell(4).getStringCellValue();
System.out.println(LeadSource);
String Industry=sh.getRow(6).getCell(5).getStringCellValue();
System.out.println(Industry);
String LeadStatus=sh.getRow(6).getCell(6).getStringCellValue();
System.out.println(LeadStatus);//
//close the workbook
workbook.close();

	}

}
