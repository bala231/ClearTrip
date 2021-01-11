package com.suite1;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pageobjects.ClearTripAppln;

public class TC_004_AddPassengerDetails extends Init {
	
	ClearTripAppln cleartrip;
	
	@Test 
	public void Add_Passenger() throws Exception {
		
		//Getting the element values from page object file
		cleartrip = PageFactory.initElements(driver, ClearTripAppln.class);
		

		//Calling the trip booking class
		cleartrip.AddPassengerDetails(driver);;
		
	}	

}
