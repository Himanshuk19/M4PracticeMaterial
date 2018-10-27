package practicePagefactoryWithTestingNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;



public class TestNGEx
{
	public int TimeoutValue = 30;
	//Prioritizer priority ;
	public WebDriver driver ;
	 pageFactory pf;
	
	@Test(priority=1)
	public void testCases() throws InterruptedException{
		//Create Chrome driver to LAunch Browser
				System.setProperty("webdriver.chrome.driver","D:/chromedriver.exe");
				driver = new ChromeDriver();

				//1. Launch Chrome Browser
				driver.get("D:\\ConferenceRegistartion.html");
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.manage().window().maximize();
			    pageFactory pf = new pageFactory(driver);
				pf = PageFactory.initElements(driver,pageFactory.class);//Initializing pagefactoory obj
				
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
				
				//verift Street Address 1
				pf.verifystreetaddress1("Delhi");
				
				//verift Street Address 2
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