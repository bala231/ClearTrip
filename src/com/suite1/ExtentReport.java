package com.suite1;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReport {
	
	ExtentReports extent;
	ExtentTest logger;
	WebDriver driver;
	
	@BeforeTest
	public void startTest() {
		
		extent = new ExtentReports(System.getProperty("user.dir")+"/test-output/ExtentReport.html",true);
	
		extent.addSystemInfo("Host Name", "Clear Trip")
		.addSystemInfo("Environment","Automation Testing")
		.addSystemInfo("User Name:", "Bala");
		
		extent.loadConfig(new File(System.getProperty("user.dir")+"//extent-config.xml"));
					
	}	
	
	public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{
	//Convert web driver object to TakeScreenshot
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);
	//Call getScreenshotAs method to create image file
	File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
	//Move image file to new destination
	File DestFile=new File(fileWithPath);
	//Copy file at destination
	FileUtils.copyFile(SrcFile, DestFile);
	}
	
	@Test
	public static String testCleartripTakeScreenShot(WebDriver driver, String destination) throws Exception{

		System.setProperty("webdriver.chrome.driver","E:\\Selenium\\Newfolder\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		driver = new ChromeDriver(options);
		
		//goto url
		
		driver.get("https://www.cleartrip.com");
		
		ExtentReport.takeSnapShot(driver, "E:\\Selenium\\SampleApplications\\ClearTripAppln\\test.png") ;
		return destination; 
		
		}
		@Test
		public void TC_001_Login(){
			
				logger = extent.startTest("passTest");
				Assert.assertTrue(true);
				logger.log(LogStatus.PASS,"Test case is passed ");
			
				//throw new SkipException("This test case is skipped ");

		}
		
		@Test
		public void TC_002_Trip() {
			
				logger = extent.startTest("passTest");
				Assert.assertTrue(true);
				logger.log(LogStatus.PASS,"Test case is passed ");
			
				//throw new SkipException("This test case is skipped ");
		}
		
		@Test
		public void TC_003_TripBook() {
			
			logger = extent.startTest("passTest");
			Assert.assertTrue(true);
			logger.log(LogStatus.PASS,"Test case is passed ");
			
			//throw new SkipException("This test case is skipped ");
		}
		
		@Test
		public void TC_004_AddPassengerDetails() {
			
			logger = extent.startTest("passTest");
			Assert.assertTrue(true);
			logger.log(LogStatus.PASS,"Test case is passed ");

			throw new SkipException("This test case is skipped ");	
		}
		
		@AfterMethod()
		public void getResult(ITestResult result) throws Exception {

			
			  if(ITestResult.FAILURE==result.getStatus()){
		            try{
		                // To create reference of TakesScreenshot
		                TakesScreenshot screenshot=(TakesScreenshot)driver;
		                // Call method to capture screenshot
		                File source=screenshot.getScreenshotAs(OutputType.FILE);
		                // Copy files to specific location 
		                FileHandler.copy(source, new File(System.getProperty("user.dir") + "/Screenshots/" +result.getName()+".png"));
		                System.out.println("Successfully captured a screenshot");
		            }
		            catch (Exception e){
		                System.out.println("Exception while taking screenshot "+e.getMessage());
		            
		            }
		           
			  }
		            else if(result.getStatus() == ITestResult.SKIP) {
				
				logger.log(LogStatus.SKIP, "Test case skipped is "+ result.getName());

	            String screenshotPath = ExtentReport.testCleartripTakeScreenShot(driver,  "E:\\Selenium\\SampleApplications\\ClearTripAppln\\test.png");
	            
	            System.out.println("Haaqqi " + screenshotPath );
	            //To add it in the extent report 
	            logger.log(LogStatus.SKIP, logger.addScreenCapture(screenshotPath));
			
		}
		
	extent.endTest(logger);
}
		@AfterTest
		public void endReport() {
			
			extent.flush();
			extent.close();
		}

		public static String getScreenhot(WebDriver driver2, String name) {
			// TODO Auto-generated method stub
			return null;
		}

}