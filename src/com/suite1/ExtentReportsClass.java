package com.suite1;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.security.auth.login.FailedLoginException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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

public class ExtentReportsClass {

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

	public static String getScreenhot(WebDriver driver, String screenshotName) throws Exception {
		
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\Newfolder\\chromedriver.exe");
		driver  = new ChromeDriver();
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		
		driver.get("currenturl/capture-screenshot-using-selenium-webdriver");

        //after execution, you could see a folder "FailedTestsScreenshots" under src folder
		String destination = System.getProperty("user.dir")+"\\Screenshots\\"+screenshotName+dateName+".png";
			
		System.out.println("Screenshot " + destination);
		
		File finalDestination = new File(destination);
		System.out.println(" Hi "+finalDestination);
		FileUtils.copyFile(source, finalDestination);
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
	public void TC_004_AddPassengerDetails() throws FailedLoginException {
		
		logger = extent.startTest("failedTest");
		Assert.assertTrue(true);
		logger.log(LogStatus.FAIL,"");

		throw new FailedLoginException("This test case is failed ");	
		
		
	}
	

	@AfterMethod(alwaysRun=true)
    public void screenShot(ITestResult result) throws Exception{
		
		//System.out.println(" Hai "+result.getStatus());
		//System.out.println(logger.getTest().getStatus());
		
	//using ITestResult.FAILURE is equals to result.getStatus then it enter into if condition
    if(result.getStatus() == ITestResult.FAILURE){
    	
        String screenshotPath = ExtentReport.getScreenhot(driver, result.getName());
        
  		//System.out.println("ScreenShotpath "+ screenshotPath);
          
          //To add it in the extent report 
          logger.log(LogStatus.FAIL, logger.addScreenCapture(screenshotPath));

}
    extent.endTest(logger);
	}
	
		@AfterTest
		public void endReport() {
			
			extent.flush();
			extent.close();
		}
	

}
