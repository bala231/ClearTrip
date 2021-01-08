package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.suite1.Init;

public class ClearTripAppln extends Init {
	
	WebDriver driver; 
	
	@FindBy(xpath = "//*[@id=\"userAccountLink\"]/span[2]")
	public
	WebElement your_trips;
	
	@FindBy(xpath = "//input[@id='SignIn']")
	public
	WebElement sign_in;
	
	@FindBy(id = "email")
	public
	WebElement user_name;
	
	//Getting pwd element
	@FindBy(xpath = "//input[@id='password']")
	public
	WebElement pwd;
	
	//Getting sign in button element
	@FindBy(id = "signInButton")
	public
	WebElement log_in;
	
	public void LoginPage(WebDriver driver) throws Exception {
		
		this.driver = driver;
		
		//Navigating to sign-in page
		your_trips.click();
		
		//Clicking on Sign-In link
		sign_in.click();
		
		//driver.switchTo().frame("modal_window");
		
		//Thread.sleep(3000);
		//Giving user name
		//user_name.sendKeys(prop.getProperty("username"));
		//user_name.sendKeys("KBalu12@Gmail.com");
		
		//Thread.sleep(3000);
		//Giving password
		//pwd.sendKeys(prop.getProperty("pwd"));
		//pwd.sendKeys("Balu123#");
		
		//Thread.sleep(3000);
		//Clicking on Login button
		//log_in.click();
	}

	//Giving the from city name	
	@FindBy(xpath="//input[@id='FromTag']")
	public
	WebElement FromTag;
	
	//Giving the to city name
	
	@FindBy(id="ToTag")
	public
	WebElement ToTag;

	@FindBy(how=How.ID,using="DepartDate")
	public
	WebElement DepartDate;
	
	@FindBy (xpath="//a[contains(text(),'10')]")
	public
	WebElement DateSelect;
		
	@FindBy (xpath="//select[@id='Adults']//option[@value='1'][contains(text(),'1')]")
	public
	WebElement AddAdult;
	
	@FindBy (xpath="//select[@id='Childrens']//option[@value='1'][contains(text(),'1')]")
	public
	WebElement AddChild;
	
	@FindBy (id="SearchBtn")
	public
	WebElement SearchFlt;

	
	public void Trip(WebDriver driver) throws Exception {
		
		this.driver = driver;
		
		driver.navigate().refresh();
		
		Thread.sleep(1000);
		
		//Giving the From city
		FromTag.sendKeys("Hyderabad");
		
		//Giving the To city
		ToTag.sendKeys("Trichy");
		
		//Selecting the date
		DepartDate.click();
		
		DateSelect.click();
		
		//Adding the adult passenger count
		AddAdult.click();
		
		//Adding the child passenger count
		AddChild.click();
		
		Thread.sleep(5000);
		
		//Clicking on Search flight button
		SearchFlt.click();
	
	}
	
	@FindBy (xpath="//*[@id=\"root\"]/div/main/div/div/div[2]/div[2]/div[8]/div[2]/div[1]/div[2]/div[4]/button")
	public
	WebElement BookFlt;
	
	@FindBy (xpath="/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/main[1]/div[2]/div[1]/div[1]/div[16]/div[3]/div[1]/div[1]/div[1]")
	public
	WebElement SelectFare;
	
	@FindBy (xpath = "//*[@id=\"root\"]/div/div[2]/div/div[1]/main/div[2]/div/div/div[24]/div[1]/button")
	public
	WebElement continue1;
	
	@FindBy (xpath="//div[@class='col-14']//div[@class='p-relative']//input[@type='text']")
	public
	WebElement mob_num;
	
	@FindBy (xpath="//div[@class='col']//div[@class='row']//div[@class='col-17']//div[@class='p-relative']//input[@type='text']")
	public
	WebElement email_add;
	
	@FindBy (xpath="//*[@id=\"root\"]/div/div[2]/div/div[1]/main/div[5]/div/div[1]/div[5]/button")
	public
	WebElement continue2;
	
	@FindBy (xpath="//*[@id=\"root\"]/div/div[2]/div/div[1]/main/div[5]/div/div[1]/div[7]/button")
	public
	WebElement continue_button;
	
	public void TripBook(WebDriver driver) throws Exception {
		
		this.driver = driver;
		
		//Wait to locate the element and booking		
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated
				(By.xpath("//*[@id='root']/div/main/div/div/div[2]/div[2]/div[8]/div[1]/div[1]/div[2]/div[4]/button")));
		
		Thread.sleep(3000);
		BookFlt.click();
	
		//Navigating to next tab and do the process
		String currentTab = driver.getWindowHandle();
		for (String tab : driver.getWindowHandles()) {
		    if (!tab.equals(currentTab)) {
		        driver.switchTo().window(tab); 
		    }       
		}
		
		Thread.sleep(4000);
		//Scroll down and selecting the fare
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0, 1200);");
		
		Thread.sleep(4000);
		SelectFare.click();
		
		Thread.sleep(1000);
		continue1.click();
		
		Thread.sleep(3000);
		mob_num.sendKeys("9160133557");
		
		if (email_add.isEnabled())
		{
			email_add.sendKeys("KBalu12@Gmail.com");
			
			Thread.sleep(3000);
			continue_button.click();
		}
		
		else
		{
			Thread.sleep(3000);
			continue2.click();
		}

		
	}
	
	@FindBy (xpath="//*[@id=\"root\"]/div/div[2]/div/div[1]/main/div[8]/div/div/div[2]/div[3]/div[1]/div/div/div[1]/input")
	public
	WebElement First_Name;
	
	@FindBy (xpath="//body/div[@id='root']/div[@class='App flex flex-column']/div[@class='container w-100p flex-1']/div[@class='row']/div[@class='col-17']/main/div[@style='overflow: visible; opacity: 1; height: auto;']/div[@class='row']/div[@class='col']/div/div[3]/div[2]/div[1]/input[1]")
	public
	WebElement Last_Name;
	
	@FindBy (xpath="//body/div[@id='root']/div[1]/div[2]/div[1]/div[1]/main[1]/div[8]/div[1]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/button[1]/div[1]")
	public
	WebElement Gender;
	
	@FindBy (xpath="/html/body/div[1]/div/div[2]/div/div[1]/main/div[8]/div/div/div[2]/div[3]/div[3]/div/div/div/ul/li[2]")
	public
	WebElement Select_Gender;
	
	@FindBy (xpath="//div[contains(text(),'Female')]")
	public
	WebElement Selected_Gender;
		
	
	//li[contains(text(),'Female')]
	
	@FindBy (xpath="/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/main[1]/div[8]/div[1]/div[1]/div[2]/div[5]/div[1]/div[1]/div[1]/div[1]/input[1]")
	public
	WebElement Nationality;
	
	@FindBy (xpath="//body/div[@id='root']/div[@class='App flex flex-column']/div[@class='container w-100p flex-1']/div[@class='row']/div[@class='col-17']/main/div[@style='overflow: visible; opacity: 1; height: auto;']/div[@class='row']/div[@class='col']/div/div[5]/div[2]/div[1]/input[1]")
	public
	WebElement Adult_DOB;
	
	@FindBy (xpath="/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/main[1]/div[8]/div[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[1]/div[1]/input[1]")
	public
	WebElement ChildFirst_Name;
	
	@FindBy (xpath="/html/body/div[1]/div/div[2]/div/div[1]/main/div[8]/div/div/div[3]/div[2]/div[2]/div/input")
	public
	WebElement ChildLast_Name;
	
	@FindBy (xpath="/html/body/div[1]/div/div[2]/div/div[1]/main/div[8]/div/div/div[3]/div[2]/div[3]/div/div/button/div")
	public
	WebElement Child_Gender;
	
	@FindBy (xpath="/html/body/div[1]/div/div[2]/div/div[1]/main/div[8]/div/div/div[3]/div[2]/div[3]/div/div/div/ul/li[1]")
	public
	WebElement SelectChild_Gender;
	
	@FindBy (xpath="/html/body/div[1]/div/div[2]/div/div[1]/main/div[8]/div/div/div[3]/div[2]/div[3]/div/div/button/div")
	public
	WebElement SelectedChild_Gender;
	
	@FindBy (xpath="/html/body/div[1]/div/div[2]/div/div[1]/main/div[8]/div/div/div[3]/div[4]/div[1]/div/div/div/input")
	public
	WebElement Child_Nationality;
	
	@FindBy (xpath="/html/body/div[1]/div/div[2]/div/div[1]/main/div[8]/div/div/div[3]/div[4]/div[2]/div[1]/input")
	public
	WebElement Child_DOB;
	
	
	@FindBy (xpath="/html/body/div[1]/div/div[2]/div/div[1]/main/div[8]/div/div/div[8]/div/button")
	public
	WebElement Continue_Pymt;
	
	public void AddPassengerDetails(WebDriver driver) throws Exception {
		
		
		this.driver = driver;
		
		Thread.sleep(3000);
		First_Name.sendKeys("Parimala");
		
		Thread.sleep(3000);
		Last_Name.sendKeys("Balamurugan");
		
		Thread.sleep(3000);
		Gender.click();
		
		Thread.sleep(3000);
		Select_Gender.click();
		
		Thread.sleep(3000);
		Selected_Gender.click();
		
		Thread.sleep(3000);
		Nationality.sendKeys("India");
		
		Thread.sleep(3000);
		Adult_DOB.sendKeys("12/01/1978");
		
		Thread.sleep(3000);
		ChildFirst_Name.sendKeys("Pranesh");
		
		Thread.sleep(3000);
		ChildLast_Name.sendKeys("Balamurugan");
		
		Thread.sleep(3000);
		Child_Gender.click();
		
		Thread.sleep(3000);
		SelectChild_Gender.click();
		
		Thread.sleep(3000);
		SelectedChild_Gender.click();
		
		Thread.sleep(3000);
		Child_Nationality.sendKeys("India");
		
		Thread.sleep(3000);
		Child_DOB.sendKeys("22/02/2013");
		
		Thread.sleep(3000);
		Continue_Pymt.click();
		
		
		
		
		
		
		
		
		
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
}
