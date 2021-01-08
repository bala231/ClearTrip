package com.suite1;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pageobjects.ClearTripAppln;

@Test
public class TC_002_Trip extends Init {

	ClearTripAppln cleartrip;

	@Test
	public void Trip() throws Exception {
		
		cleartrip = PageFactory.initElements(driver, ClearTripAppln.class);
		
		//Calling the trip class
		cleartrip.Trip(driver);
		
	}

	
}




