package com.tutorialsninja.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class utils {  
	
	public static final int IMPLICIT_WAIT_TIME=10;
	public static final int PAGE_LOAD_TIME=5;
	
	public static String generateemailwithtimestamp() {
		Date date=new Date();
       String timestamp = date.toString().replace(" ", "_").replace(":", "_");
       return"ashish"+timestamp+"@gmail.com";
	}
	
	public static Object[][] gettestdatafromexcel(String sheetname) {
		File excelfile =new File(System.getProperty("user.dir")+"\\src\\main\\java\\testdata\\tutorialsninjatestdata.xlsx");
		XSSFWorkbook workbook=null;
		try {
		FileInputStream fisexcel=new FileInputStream(excelfile);
		 workbook=new XSSFWorkbook(fisexcel);
		}catch(Throwable e) {
			e.printStackTrace();
		}
		 XSSFSheet sheet = workbook.getSheet(sheetname);
		
		int rows =sheet.getLastRowNum();
		int cls =sheet.getRow(0).getLastCellNum();
		
		Object[][] data =new Object[rows][cls];
		
		for(int i=0;i<rows;i++) {
			XSSFRow row = sheet.getRow(i+1);
			
			for(int j=0;j<cls;j++) {
				XSSFCell cell = row.getCell(j);
				CellType celltype = cell.getCellType();
				
				switch(celltype) 
				{
				
				case STRING:
					data[i][j]=cell.getStringCellValue();
					break;
					
				case NUMERIC:
					data[i][j] = Integer.toString((int)cell.getNumericCellValue());
				break;
				
				case BOOLEAN:
				data[i][j]=cell.getBooleanCellValue();
				break;
				}
			}
		}
	return data;
	}
	
 public static String capturescreenshot(WebDriver driver,String testname) {
	 
		File srcscreenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destinationscreenshotpath=System.getProperty("user.dir")+"\\screenshots\\"+testname+".png";
		try {
			FileHandler.copy(srcscreenshot,new File(destinationscreenshotpath));
		} catch (IOException e) {
			
			e.printStackTrace();
		}

		return destinationscreenshotpath;
 }
	
	
	
	
}
