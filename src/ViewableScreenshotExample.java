import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ViewableScreenshotExample {
	  WebDriver driver;
	    
	    @BeforeTest
	    public void setupUrl()
	    {
	        System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\Newfolder\\chromedriver.exe");
	        driver=new ChromeDriver();
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        driver.manage().window().maximize();
	        driver.get("https://www.airbnb.co.in/s/India/");
	        
	        
	    }
	    
	    @Test
	    public void performAction() throws InterruptedException
	    {
	        //Scroll down the page
	        JavascriptExecutor jse = (JavascriptExecutor)driver;
	        jse.executeScript("window.scrollBy(0,250)", "");
	        
	        
	        //open the stay details page
	        driver.findElement(By.xpath("//div[contains(text(), 'Sea Hut Homestay with Aircon')]")).click();
	        Thread.sleep(1500);
	        
	        //Switch to the required tab
	        ArrayList<String> ta = new ArrayList<String> (driver.getWindowHandles());
	        int i=ta.size();
	        System.out.println(i);
	        driver.switchTo().window(ta.get(1));
	    }
	    
	    @AfterTest
	    public void takeScreenshot()
	    {
	        //take screenshot of the page
	        File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	        try {
	            FileUtils.copyFile(src, new File("E:\\Selenium\\SampleApplications\\ClearTripAppln\\TEsting.png"));
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	    }
}
