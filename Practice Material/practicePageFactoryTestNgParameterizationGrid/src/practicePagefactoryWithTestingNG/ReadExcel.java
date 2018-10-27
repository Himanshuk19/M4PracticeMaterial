package practicePagefactoryWithTestingNG;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import pageFactoryWithTestNG.*;
import org.openqa.selenium.support.PageFactory;

public class ReadExcel
{
	public static void main(String[] args) throws Exception 
	{
		File src= new File("D:\\Register.xlsx");
		//using Java API specify workbook path
		FileInputStream fis = new FileInputStream(src);
		//to load entire workbook use XSSFWorkbook class
		XSSFWorkbook wb1 = new XSSFWorkbook(fis);  //XSS used for .xlsx file
		//HSSFWorkbook wb1 = new HSSFWorkbook(fis); //HSS used for .xls file
		//to get the access of sheet 1 use XSSFSheet class
		XSSFSheet Sheet1 = wb1.getSheetAt(0);
		//to read 1st row and col from sheet 1
		// to get the count of no. of rows present in sheet
				
		String firstname=Sheet1.getRow(1).getCell(0).getStringCellValue();
		String lastname=Sheet1.getRow(1).getCell(1).getStringCellValue();
		String email=Sheet1.getRow(1).getCell(2).getStringCellValue();
		long contact=(long) Sheet1.getRow(1).getCell(3).getNumericCellValue();	
		String street1=Sheet1.getRow(1).getCell(4).getStringCellValue();
		String street2=Sheet1.getRow(1).getCell(5).getStringCellValue();
		
		System.out.println(firstname);
		System.out.println(lastname);
		System.out.println(email);
		System.out.println(contact);
		System.out.println(street1);
		System.out.println(street2);
		
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("D:\\ConferenceRegistartion.html");
		driver.findElement(By.xpath("//*[@id='txtFirstName']")).sendKeys(firstname);
		driver.findElement(By.xpath("//*[@id='txtLastName']")).sendKeys(lastname);
		driver.findElement(By.xpath("//*[@id='txtEmail']")).sendKeys(email);
		driver.findElement(By.xpath("//*[@id='txtPhone']")).sendKeys(contact+"");
		
	    pageFactory pf = new pageFactory(driver);
		pf = PageFactory.initElements(driver,pageFactory.class);//Initializing pagefactoory obj
		  
		//verify Number of People Attending Alert message 
		pf.verifypeople(2);
		
		driver.findElement(By.xpath("//*[@id='txtAddress']")).sendKeys(street1);
		driver.findElement(By.xpath("//*[@id='txtAddress2']")).sendKeys(street2);
		
		//verify City Alert message 
		pf.verifycity(2);
		
		//verify State Alert message 
		pf.verifystate(1);
		
		pf.selectconfrence();
		
		pf.submit.click();
		
		pf.acceptalert();
		
		driver.findElement(By.xpath("/html/body/form/table/tbody/tr[14]/td/a")).click();
		//driver.close();
		wb1.close();  
	}
}