package com.suite1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.formula.functions.Rows;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageobjects.ClearTripAppln;

public class Init {
	
	public static WebDriver driver;
	static ClearTripAppln cleartrip;

@BeforeTest
	public static WebDriver Initalization() throws EncryptedDocumentException, InvalidFormatException, FileNotFoundException, IOException, Exception{
		
		//Disabling the notifications in Chrome
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		//Getting the web driver location
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\Newfolder\\chromedriver.exe");
		driver  = new ChromeDriver(options);
		
		//Disabling the notifications in Firefox
		//FirefoxOptions  options1 = new FirefoxOptions();
		//options1.addArguments("--disable-notifications");
		
		//Getting the web driver location
		//System.setProperty("webdriver.gecko.driver", "E:\\Selenium\\Newfolder\\geckodriver.exe");
		//driver  = new FirefoxDriver();
		
        //get the excel sheet file location               
        String filepath="E:\\Selenium\\SampleApplications\\ClearTripAppln\\DataSheet.xlsx";
		Workbook wb= WorkbookFactory.create(new FileInputStream(new File(filepath)));
		
        //get the sheet which needs read operation
        Sheet sh = wb.getSheet("sheet1");
            
        String url =sh.getRow(0).getCell(1).getStringCellValue();
	    String email =sh.getRow(1).getCell(1).getStringCellValue();
		String pwd =sh.getRow(2).getCell(1).getStringCellValue();
		
	    
        driver.get(url);
        
		// Maximizing the window
		driver.manage().window().maximize();
		
  
		Thread.sleep(3000);
        cleartrip = PageFactory.initElements(driver, ClearTripAppln.class);
        cleartrip.LoginPage(driver);
 	    
        Thread.sleep(3000);
		driver.switchTo().frame("modal_window");
		
		Thread.sleep(3000);
	    WebElement username = driver.findElement(By.id("email"));
	    WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
	    WebElement login = driver.findElement(By.id("signInButton"));

		Thread.sleep(3000);
		//Giving user name
		username.sendKeys(email);
		
		Thread.sleep(1000);
		//Giving password
		password.sendKeys(pwd);
		
		Thread.sleep(2000);
		//Clicking on Login button
		login.click();
		

		return driver;

		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	

	
	
}
