package practicePagefactoryWithTestingNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import practicePagefactoryWithTestingNG.pageFactory;



public class pageFactory
{
	public static WebDriver driver;
	boolean fn,ln,ema,co,pe,sad1,sad2,ci,st;
	public pageFactory(WebDriver driver)
	{
		pageFactory.driver =driver;
	}

	@FindBy(xpath="/html/body/h2")
	@CacheLookup // to store the element in cache memory
	WebElement head;
	
	//using Xpath
	@FindBy(how=How.XPATH, using="//*[@id='txtFirstName']")
	@CacheLookup
	WebElement fname;
	
	@FindBy(how=How.XPATH, using="//*[@id='txtLastName']")
	@CacheLookup
	WebElement lname;
	
	@FindBy(how=How.XPATH, using="//*[@id='txtEmail']")
	@CacheLookup
	WebElement email;
	
	@FindBy(how=How.XPATH, using="//*[@id='txtPhone']")
	@CacheLookup
	WebElement contact;
	
	@FindBy(how=How.XPATH, using="/html/body/form/table/tbody/tr[5]/td[2]/select")
	@CacheLookup
	WebElement people;
	
//	@FindBy(how=How.XPATH, using="//*[@id='txtAddress']")
//	@CacheLookup
//	WebElement add;
	
	@FindBy(how=How.XPATH, using="//*[@id='txtAddress']")
	@CacheLookup
	WebElement streetadd1;
	
	@FindBy(how=How.XPATH, using="//*[@id='txtAddress2']")
	@CacheLookup
	WebElement streetadd2;
	
	@FindBy(how=How.XPATH, using="/html/body/form/table/tbody/tr[9]/td[2]/select")
	@CacheLookup
	WebElement city;
	
	@FindBy(how=How.XPATH, using="/html/body/form/table/tbody/tr[10]/td[2]/select")
	@CacheLookup
	WebElement state;
	
	@FindBy(name="conference")
	@CacheLookup
	WebElement con;	
	
	@FindBy(xpath="/html/body/form/table/tbody/tr[14]/td/a")
	@CacheLookup
	public WebElement submit;	
	
	public String getTitle(){
		return driver.getTitle();
	}
	
	public void enterfirstname(String fna)
	{
		fname.sendKeys(fna);
	}

	public void enterlastname(String ln)
	{
		lname.sendKeys(ln);
	}
	
	public void enteremail(String em)
	{
		email.sendKeys(em);
	}
	
	public void entercontact(String c)
	{
		contact.sendKeys(c);
	}
	
	public void selectpeople(int index) 
	{
		Select peo = new Select(people); 
		peo.selectByIndex(index);
	}
//	
//	public void enteraddress(String ad)
//	{
//		add.sendKeys(ad);
//	}
//	
	public void enterstreetadd1(String ad1)
	{
		streetadd1.sendKeys(ad1);
	}
	
	public void enterstreetadd2(String ad2)
	{
		streetadd2.sendKeys(ad2);
	}
	
	public void selectcity(int index) 
	{
		Select ci = new Select(city); 
		ci.selectByIndex(index);
	}
	
	public void selectstate(int index) 
	{
		Select st = new Select(state); 
		st.selectByIndex(index);
	}
	
	public void selectconfrence() 
	{
		con.click();
	}
	
	public boolean isAlertPresent(){
		 try{
		  driver.switchTo().alert();
		  return true;
		 }catch(NoAlertPresentException ex){
		  return false;
		 }
		}

	//test title
	public boolean testTitle(String expTitle)
	{
		String actualTitle="";
		//boolean valid=false;
		actualTitle=driver.getTitle();
		if (actualTitle.contentEquals(expTitle))
		{
			System.out.println(actualTitle+": Title Test Passed!");
			return true;
		} 
		else 
		{
			System.out.println(actualTitle+": Title Test Failed");
			driver.quit();
			return false;
		}
	}
	public void verifyfirstname(String f) throws InterruptedException  
	{
		fn=fname.isDisplayed();
		if(fn=true) 
		{
			System.out.println("First Name textbox present");
			enterfirstname("");//leaving blank
			submit.click();
			Thread.sleep(2000);
			Alert alert = driver.switchTo().alert();
			String expectedAlertMessage="Please fill the First Name";
			String actualAlertMessage= driver.switchTo().alert().getText();
			System.out.println(actualAlertMessage);
			if(expectedAlertMessage.contentEquals(actualAlertMessage))
			{
				System.out.println("Alert message verification for First name - Passed");
				alert.accept();
				enterfirstname(f);
			}
			else
			{
				System.out.println("Alert message verification for First name - Failed");
				alert.accept();
				enterfirstname(f);
			}

		}
		else
		{
			System.out.println("First Name textbox not present");
		}
	}
	public void verifylastname(String l) throws InterruptedException  
	{
		ln=lname.isDisplayed();
		if(ln=true) 
		{
			System.out.println("Last Name textbox present");
			enterlastname("");//leaving blank
			submit.click();
			Thread.sleep(2000);
			Alert alert = driver.switchTo().alert();
			String expectedAlertMessage="Please fill the Last Name";
			String actualAlertMessage= driver.switchTo().alert().getText();
			System.out.println(actualAlertMessage);
			if(expectedAlertMessage.contentEquals(actualAlertMessage))
			{
				System.out.println("Alert message verification for Last name - Passed");
				alert.accept();
				enterlastname(l);
			}
			else
			{
				System.out.println("Alert message verification for Last name - Failed");
				alert.accept();
				enterlastname(l);
			}

		}
		else
		{
			System.out.println("Last Name textbox not present");
		}
	}
	public void verifyemail(String e) throws InterruptedException  
	{
		ema=email.isDisplayed();
		if(ema=true) 
		{
			System.out.println("Email textbox present");
			enteremail("");//leaving blank
			submit.click();
			Thread.sleep(2000);
			Alert alert = driver.switchTo().alert();
			String expectedAlertMessage="Please fill the Email";
			String actualAlertMessage= driver.switchTo().alert().getText();
			System.out.println(actualAlertMessage);
			if(expectedAlertMessage.contentEquals(actualAlertMessage))
			{
				System.out.println("Alert message verification for Email - Passed");
				alert.accept();
				enteremail(e);
			}
			else
			{
				System.out.println("Alert message verification for Email - Failed");
				alert.accept();
				enteremail(e);
			}

		}
		else
		{
			System.out.println("Email textbox not present");
			
		}
	}
	public void verifycontact(String c) throws InterruptedException  
	{
		co=contact.isDisplayed();
		if(co=true) 
		{
			System.out.println("Contact Number textbox present");
			entercontact("");//leaving blank
			submit.click();
			Thread.sleep(2000);
			Alert alert = driver.switchTo().alert();
			String expectedAlertMessage="Please fill the Contact No.";
			String actualAlertMessage= driver.switchTo().alert().getText();
			System.out.println(actualAlertMessage);
			if(expectedAlertMessage.contentEquals(actualAlertMessage))
			{
				System.out.println("Alert message verification for Contact Number - Passed");
				alert.accept();
				entercontact(c);
			}
			else
			{
				System.out.println("Alert message verification for Contact Number - Failed");
				alert.accept();
				entercontact(c);
			}

		}
		else
		{
			System.out.println("Contact Number textbox not present");
		}
	}
	public void verifypeople(int index) throws InterruptedException{
		pe = people.isDisplayed();
		if(pe){
			submit.click();
			System.out.println("Number of people attending dropdown is present");
			//selectpeople(-1); //address
			//submit.click();
			Thread.sleep(2000);
			//System.out.println("SELECTED"+);
			if(isAlertPresent()){
				Alert alert = driver.switchTo().alert();
				String expectedAlertMessage="Please fill the Number of people attending";
				String actualAlertMessage= driver.switchTo().alert().getText();
				if(expectedAlertMessage.contentEquals(actualAlertMessage))
				{
					System.out.println("Alert message verification for Number of people attending - Passed");
					alert.accept();
					selectpeople(index);//valid data
				}
				else
				{
					System.out.println("Alert message verification for Number of people attending - Failed");
					alert.accept();
					selectpeople(index);//valid data
				}
				}

			}
			else
			{
				System.out.println("Number of people attending textbox not present");
			}
	}
	public void verifystreetaddress1(String sadd1) throws InterruptedException  
	{
		sad1=streetadd1.isDisplayed();
		if(sad1=true) 
		{
			System.out.println("Street Address 1 textbox present");
			enterstreetadd1("");//leaving blank
			submit.click();
			Thread.sleep(2000);
			Alert alert = driver.switchTo().alert();
			String expectedAlertMessage="Please fill the Address";
			String actualAlertMessage= driver.switchTo().alert().getText();
			System.out.println(actualAlertMessage);
			if(expectedAlertMessage.contentEquals(actualAlertMessage))
			{
				System.out.println("Alert message verification for Street Address 1 - Passed");
				alert.accept();
				enterstreetadd1(sadd1);
			}
			else
			{
				System.out.println("Alert message verification for Street Address 1 - Failed");
				alert.accept();
				enterstreetadd1(sadd1);
			}

		}
		else
		{
			System.out.println("Street Address 1 textbox not present");
		}
	}
	public void verifystreetaddress2(String sadd2) throws InterruptedException  
	{
		sad2=streetadd2.isDisplayed();
		if(sad2=true) 
		{
			System.out.println("Street Address 2 textbox present");
			enterstreetadd1("");//leaving blank
			submit.click();
			Thread.sleep(2000);
			Alert alert = driver.switchTo().alert();
			String expectedAlertMessage="Please fill the Email";
			String actualAlertMessage= driver.switchTo().alert().getText();
			System.out.println(actualAlertMessage);
			if(expectedAlertMessage.contentEquals(actualAlertMessage))
			{
				System.out.println("Alert message verification for Street Address 2 - Passed");
				alert.accept();
				enterstreetadd2(sadd2);
			}
			else
			{
				System.out.println("Alert message verification for Street Address 2 - Failed");
				alert.accept();
				enterstreetadd2(sadd2);
			}

		}
		else
		{
			System.out.println("Street Address 2 textbox not present");
		}
	}
	public void verifycity(int index) throws InterruptedException{
		ci = city.isDisplayed();
		if(ci){
			submit.click();
			System.out.println("City dropdown is present");
			//selectpeople(-1); //address
			//submit.click();
			Thread.sleep(2000);
			//System.out.println("SELECTED"+);
			if(isAlertPresent()){
				Alert alert = driver.switchTo().alert();
				String expectedAlertMessage="Please select the City";
				String actualAlertMessage= driver.switchTo().alert().getText();
				if(expectedAlertMessage.contentEquals(actualAlertMessage))
				{
					System.out.println("Alert message verification for City - Passed");
					alert.accept();
					selectcity(index);//valid data
				}
				else
				{
					System.out.println("Alert message verification for City - Failed");
					alert.accept();
					selectcity(index);//valid data
				}
				}

			}
			else
			{
				System.out.println("City textbox not present");
			}
	}
	public void verifystate(int index) throws InterruptedException{
		st = state.isDisplayed();
		if(st){
			submit.click();
			System.out.println("State dropdown is present");
			//selectpeople(-1); //address
			//submit.click();
			Thread.sleep(2000);
			//System.out.println("SELECTED"+);
			if(isAlertPresent()){
				Alert alert = driver.switchTo().alert();
				String expectedAlertMessage="Please select the State";
				String actualAlertMessage= driver.switchTo().alert().getText();
				if(expectedAlertMessage.contentEquals(actualAlertMessage))
				{
					System.out.println("Alert message verification for State - Passed");
					alert.accept();
					selectstate(index);//valid data
				}
				else
				{
					System.out.println("Alert message verification for State - Failed");
					alert.accept();
					selectstate(index);//valid data
				}
				}

			}
			else
			{
				System.out.println("State textbox not present");
			}
	}

	public void acceptalert() {
			Alert alert = driver.switchTo().alert();
			alert.accept();
			//alert.accept();
		
	}
	public static void main(String args[]) throws InterruptedException
	{
		
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
		driver = new ChromeDriver();

		//1. Launch Chrome Browser
		driver.get("D:\\ConferenceRegistartion.html");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		pageFactory pf = new pageFactory(driver);
		pf = PageFactory.initElements(driver, pageFactory.class);
		
		//Verify Title
		pf.testTitle("Conference Registartion");
		
		//verify First Name Alert message 
		pf.verifyfirstname("Himanshu");
		
		//verify Last Name Alert message 
		pf.verifylastname("Kataria");
		
		//verify Mail ID Alert message 
		pf.verifyemail("himanshu@gmail.com");
		
		//verify Phone Number Alert message 
		pf.verifycontact("9873662987");
		
		//verify Number of people attending Alert message 
		pf.verifypeople(2);
		
		//verify Street Address 1
		pf.verifystreetaddress1("Delhi");
		
		//verify Street Address 2
		pf.verifystreetaddress2("Yamuna Vihar");
		
		//verify City Alert message 
		pf.verifycity(2);
		
		//verify State Alert message 
		pf.verifystate(1);
		
		
		pf.selectconfrence();
		
		pf.submit.click();
		
		pf.acceptalert();
		
		
		//close the browser
		//driver.close();
	}
}