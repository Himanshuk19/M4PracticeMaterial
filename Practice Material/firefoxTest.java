package webDrivers;

//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class firefoxTest {

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.firefox.bin","C:\\Users\\hkataria\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
		FirefoxProfile profile=new FirefoxProfile();
		profile.setPreference("network.proxy.type",1);
		profile.setPreference("network.proxy.http", "10.219.96.26");
		profile.setPreference("network.proxy.http_port",8080);
		profile.setPreference("network.proxy.ssl","10.219.96.26");
		profile.setPreference("network.proxy.ssl_port",8080);
		
		FirefoxDriver driver= new FirefoxDriver(profile);
		String base="https://demo.opencart.com/";
		driver.navigate().to(base);
		Thread.sleep(500);
		System.out.println(driver.getTitle());
		
	}

}
