package com.suite2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageobjects.FlipkartAppln;

public class TC_001_FirstTestNGFile {
	
	WebDriver dr;
	FlipkartAppln flipkart;
	
	Properties prop = new Properties();
			
	@BeforeClass
	public void init() throws IOException {
		
		
		//Getting the web driver location
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\Newfolder\\chromedriver.exe");
		dr  = new ChromeDriver();
	
		//Getting the web driver location
		//System.setProperty("webdriver.gecko.driver", "E:\\Selenium\\Newfolder\\geckodriver.exe");
		//dr  = new FirefoxDriver();		//Getting the web driver location
		
		//System.setProperty("webdriver.edge.driver", "E:\\Selenium\\Newfolder\\msedgedriver.exe");
		//dr  = new EdgeDriver();
		
		// Reading the configuration file
		FileInputStream fis = new FileInputStream("C:\\Users\\balamurugan\\eclipse-workspace\\FlipkartAppln\\configs\\config.properties");
		prop.load(fis);
		
		//Opening the site
		String url = prop.getProperty("url");
		dr.get(url);

		// Maximizing the window
		dr.manage().window().maximize();
	
	}
	
	@Test (priority=1)
  public void login() throws Exception {
		
 		//Getting the element values from page object file
		flipkart = PageFactory.initElements(dr, FlipkartAppln.class);
		Thread.sleep(1000);
		
		// Reading the configuration file
		FileInputStream fis = new FileInputStream("C:\\Users\\balamurugan\\eclipse-workspace\\FlipkartAppln\\configs\\config.properties");
		prop.load(fis);
		
		//Opening the site
		String mobilenum = prop.getProperty("mobilenum");
		String pwd = prop.getProperty("pwd");
				
		//Sign in to page - Giving the mobile number
		flipkart.Mob_Num.sendKeys(mobilenum);
		
		//Giving the password
		flipkart.PWD.sendKeys(pwd);
		
		//Clicking on log-in button
		flipkart.Sign_In.click();
		
}

	@Test (priority=2)
	public void buying_prod() throws Exception
	{
		
		//Getting the element values from page object file
		flipkart = PageFactory.initElements(dr, FlipkartAppln.class);
		Thread.sleep(1000);

		Thread.sleep(2000);
		Actions builder = new Actions(dr);
		Thread.sleep(5000);
		WebElement element = flipkart.Men_Category;
		builder.moveToElement(element).build().perform();
		
		if (flipkart.Men_Category.isDisplayed())
		{
			//Navigating to Men
			flipkart.Men_Category.click();
			
			Thread.sleep(5000);
			//Clicking on T-Shirts link
			flipkart.TShirts.click();
			
			Thread.sleep(7000);
			//Clicking on Low to High link
			flipkart.LowTo_High.click();
		}
		 
			

		Thread.sleep(3000);
		//Searching the product
		flipkart.Search_Prod.sendKeys("Sport Shoes");
		
		//Thread.sleep(3000);
		//Selecting the product
		flipkart.Select_Prod.click();
		
		//Selected the product
		Thread.sleep(5000);
		flipkart.Selected_Prod.click();
		
		//Navigating to next tab and do the process
		String currentTab = dr.getWindowHandle();
		for (String tab : dr.getWindowHandles()) {
		    if (!tab.equals(currentTab)) {
		        dr.switchTo().window(tab); 
		    }       
		}
		
		//Scroll down and selecting the size
		JavascriptExecutor js = (JavascriptExecutor) dr;
		js.executeScript("scroll(0,750);");
		
		//Selected the size
		Thread.sleep(5000);
		flipkart.Selected_Size.click();
		
		//Added the product to cart
		Thread.sleep(5000);
		flipkart.AddToCart.click();
		
		//Search other product
		Thread.sleep(5000);
		flipkart.Search_OtherProduct.sendKeys("Mobiles");
		
		//Select other product
		Thread.sleep(5000);
		flipkart.Select_OtherProduct.click();
		
		
	}
	
	
}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	