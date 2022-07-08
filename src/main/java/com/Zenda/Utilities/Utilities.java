package com.Zenda.Utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.Zenda.Base.BaseClass;

public class Utilities extends BaseClass {

	   public static String GetExcelData(String SheetName,int rowindex,int cellindex ) throws EncryptedDocumentException, IOException {
	        String value="";
	        FileInputStream File = new FileInputStream(dir+getPath().getProperty("Excelpath"));
	        Sheet MySheet = WorkbookFactory.create(File).getSheet(SheetName);

	        try {
	            value=MySheet.getRow(rowindex).getCell(cellindex).getStringCellValue();

	        } catch (Exception e)
	        {
	            double num = MySheet.getRow(rowindex).getCell(cellindex).getNumericCellValue();
	            int num2 = (int)num;
	            value=num2+"";
	        }
	        return value;
	   }

}
