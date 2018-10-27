package practicePagefactoryWithTestingNG;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

//import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

import practicePagefactoryWithTestingNG.pageFactory;

public class GridPractice {
	static DesiredCapabilities capabilities;
	static WebDriver driver;

	public static void setPropChrome(){

		System.setProperty("webdriver.chromedriver.driver", "D:\\chromedriver.exe");
		capabilities = DesiredCapabilities.chrome();
		capabilities.setBrowserName("chrome");
		capabilities.setCapability("webdriver.chromedriver.driver", "D:\\chromedriver.exe");
		//driver=new ChromeDriver();
		capabilities.setPlatform(Platform.WINDOWS);
	}
	
	public static void main(String[] args) throws InterruptedException, MalformedURLException 

	{
		//setPropIE();
		setPropChrome();
		//capabilities.setVersion(version);
		driver = new RemoteWebDriver(new URL("http://localhost:6666/wd/hub"), capabilities);
		try {
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
		catch(Exception ex){
			System.out.println("Hello"+ex);
		}
		//driver.quit();
	}
	
}
