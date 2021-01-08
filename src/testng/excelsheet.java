package testng;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class excelsheet 
{
	public static WebDriver driver;
	
  @Test
  public void excel() throws EncryptedDocumentException, InvalidFormatException, FileNotFoundException, IOException { 
	  
		//Getting the web driver location
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\Newfolder\\chromedriver.exe");
		driver  = new ChromeDriver();
		
                //get the excel sheet file location               
                String filepath="E:\\Selenium\\SampleApplications\\ClearTripAppln\\DataSheet.xlsx";
	   				Workbook wb= WorkbookFactory.create(new FileInputStream(new File(filepath)));
                //get the sheet which needs read operation
		            Sheet sh = wb.getSheet("sheet1");
		            
	                String url =sh.getRow(0).getCell(1).getStringCellValue();
	                System.out.println(url);
	                driver.get(url);
	                
	        		// Maximizing the window
	        		driver.manage().window().maximize();
	        		


		          }
  

	
}