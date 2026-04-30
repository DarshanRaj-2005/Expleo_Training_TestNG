package com.utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.apache.poi.ss.usermodel.Cell;

public class UtilsExcel {
	
	String path = "C:\\Users\\dhars\\Documents\\SeleniumAndTesting\\DemoblazeWithoutPageFactory\\src\\test\\resources\\DemoblazeLoginData.xlsx";
	
	@DataProvider(name = "validData")
	public Object[][] validData() throws IOException {
		Object[][] arrobj = getExcelData(path,"sheet1");
		return new Object[][] {arrobj[0]};
	}
	
	@DataProvider(name = "invalidData")
	public Object[][] invalidData() throws IOException {
		Object[][] arrobj = getExcelData(path,"sheet1");
		return new Object[][] {arrobj[1],arrobj[2]};
	}
	
	
	
	public String[][] getExcelData(String path, String sheetName) throws IOException {
		
		String data[][] = null;
		
		FileInputStream fis = new FileInputStream(path);
		
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet(sheetName);
		
		XSSFRow row = sheet.getRow(0);
		
		int noOfRow = sheet.getPhysicalNumberOfRows();
		int noOfCols = row.getLastCellNum();
		
		Cell cell;
		
		data = new String[noOfRow - 1][noOfCols];
		
		for(int i = 1;i < noOfRow;i++) {
			row = sheet.getRow(i);
			
			for(int j = 0;j < noOfCols;j++) {
				cell = row.getCell(j);
				
				data[i - 1][j] = cell.getStringCellValue();
			}
		}
		
		workbook.close();
		fis.close();
		return data;
	}

}
