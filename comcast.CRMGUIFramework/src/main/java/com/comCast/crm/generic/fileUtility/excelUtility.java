package com.comCast.crm.generic.fileUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class excelUtility {
public String getDataFromExcel(String sheetName,int rowNum,int cellNum) throws EncryptedDocumentException, IOException {
	FileInputStream fis=new FileInputStream("./testData/Book4.xlsx");
	Workbook wb= WorkbookFactory.create(fis);
	String data=wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
	wb.close();
	return data;
}
public int getRowCount(String SheetName) throws EncryptedDocumentException, IOException {
	FileInputStream fis=new FileInputStream("./testData/Book4.xlsx");
	Workbook wb= WorkbookFactory.create(fis);
int rowCount=	wb.getSheet(SheetName).getLastRowNum();
wb.close();
	return rowCount;
}
public void setDataIntoExcel(String SheetName,int rowNum,int cellNum,String data) throws EncryptedDocumentException, IOException {
	FileInputStream fis=new FileInputStream("./testData/Book4.xlsx");
	Workbook wb= WorkbookFactory.create(fis);
	wb.getSheet(SheetName).getRow(rowNum).createCell(cellNum);
	FileOutputStream fos=new FileOutputStream("./testData/Book4.xlsx");
	wb.write(fos);
	wb.close();
}

}
