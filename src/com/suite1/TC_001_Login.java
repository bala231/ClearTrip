package com.suite1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;


import pageobjects.ClearTripAppln;

@Test
public class TC_001_Login extends Init {

	TC_001_Login() {
	}

	@AfterMethod
	public WebDriver getDriver() {
		
		//driver.close();
		return driver;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
