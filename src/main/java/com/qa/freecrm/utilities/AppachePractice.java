package com.qa.freecrm.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class AppachePractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FileInputStream fiStream;
		XSSFWorkbook workbook;
		XSSFSheet sheet = null;
		XSSFRow row;
		XSSFCell cell;
		
		
		try {
			fiStream = new FileInputStream("C:\\\\Users\\\\asus\\\\eclipse-workspace\\\\AutomationProject\\\\src\\\\main\\\\java\\\\com\\\\qa\\\\freecrm\\\\testdata\\\\CrmData.xlsx");
			workbook = new XSSFWorkbook(fiStream);
			sheet = workbook.getSheetAt(0);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int rowCount = sheet.getLastRowNum()+1;
		
		row = sheet.getRow(0);
		int colCount = row.getLastCellNum();
		
		for(int rowNum = 0; rowNum < rowCount; rowNum++) {
			
			for(int colNum = 0; colNum < colCount; colNum++) {
				
				row = sheet.getRow(rowNum);
				cell = row.getCell(colNum);
				String cellData = cell.getStringCellValue();
				
				System.out.println(cellData);
			}
		}
		
		
	}

}
