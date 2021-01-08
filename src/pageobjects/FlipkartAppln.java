package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class FlipkartAppln {
	
	//Navigating to sign-in page
	@FindBy(how=How.XPATH,using = "//div[@class='IiD88i _351hSN']//input[@type='text']")
	public 
	WebElement Mob_Num;
	
	@FindBy(how=How.XPATH,using = "//input[@type='password']")
	public 
	WebElement PWD;
	
	@FindBy(how=How.XPATH,using = "//div[@class='_1D1L_j']//button[@type='submit']")
	public 
	WebElement Sign_In;
	
	
	@FindBy(how=How.XPATH,using = "//span[contains(text(),'Men')]")
	public
	WebElement Men_Category;
	
	@FindBy(how=How.XPATH,using = "/html[1]/body[1]")
	public
	WebElement TShirts;
	
	@FindBy(how=How.XPATH,using = "//div[contains(text(),'Price -- Low to High')]")
	public
	WebElement LowTo_High;
	
	@FindBy(how=How.XPATH,using = "//div[@class='_3OO5Xc']//input[@type='text']")
	public
	WebElement Search_Prod;
		
	@FindBy(how=How.XPATH,using="//button[@type='submit']//*[@width='20']")
	public
	WebElement Select_Prod;

	@FindBy(how=How.XPATH,using="/html/body/div/div/div[3]/div[2]/div[1]/div[2]/div[2]/div/div[1]/div/a/div[1]/div/div/div/img")
	public
	WebElement Selected_Prod;
	
	@FindBy(how=How.XPATH,using="/html/body/div[1]/div/div[3]/div[1]/div[2]/div[5]/div/div[2]/div[1]/ul/li[2]/a")
	public
	WebElement Selected_Size;
	
	@FindBy(how=How.XPATH,using="/html/body/div[1]/div/div[3]/div[1]/div[1]/div[2]/div/ul/li[1]/button")
	public
	WebElement AddToCart;
	
	
	@FindBy(how=How.XPATH,using="//input[@type='text']")
	public
	WebElement Search_OtherProduct;
	
	@FindBy(how=How.XPATH,using="//button[@type='submit']//*[@width='20']")
	public
	WebElement Select_OtherProduct;
	
	
	@FindBy(how=How.XPATH,using="//*[@id=\"container\"]/div/div[1]/div[1]/div[2]/div[2]/form/div/div/input")
	public
	WebElement SearchProduct;
	
	@FindBy(how=How.XPATH,using="//*[@id=\"container\"]/div/div[1]/div[1]/div[2]/div[2]/form/div/button/svg")
	public
	WebElement SearcedhProdut;
}

	
	
	
	
	
	
	
	
	
	
	
	
	
