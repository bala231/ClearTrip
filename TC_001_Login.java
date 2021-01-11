package com.suite1;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

public class TC_001_Login extends Init{

	TC_001_Login() {
	}
	
	@AfterMethod
	public WebDriver getDriver() {
		
		//driver.close();
		return driver;

	
	
}
 
}