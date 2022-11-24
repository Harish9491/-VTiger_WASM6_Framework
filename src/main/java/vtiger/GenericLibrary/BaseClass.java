package vtiger.GenericLibrary;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;

/**
 * This is the class consists of all basic configuration annotations
 * @author Harish
 *
 */
public class BaseClass {
	
	public PropertyFileLibrary pLib = new PropertyFileLibrary();
	public ExcelFileLibrary eLib = new ExcelFileLibrary();
	public WebDriverLibrary wLib = new WebDriverLibrary();
	public JavaLibrary jLib = new JavaLibrary();
	public WebDriver driver = null;
	public static WebDriver sDriver = null;

	@BeforeSuite(groups = {"smokeSuite", "regressionSuite"})
	public void bsConfig()
	{
//		System.out.println("--- DataBase connected successfully ---");
		Reporter.log("--- DataBase connected successfully ---", true);
	}
	
//	@Parameters("browser")
//	@BeforeTest
	@BeforeClass(groups = {"smokeSuite", "regressionSuite"})
	public void bcConfig(/* String BROWSER */) throws IOException
	{
		String BROWSER = pLib.readDataFromPropertyFile("browser");
		String URL = pLib.readDataFromPropertyFile("url");
		
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
//			System.out.println("--- Browser launched successfully: "+ BROWSER + " ---");
			Reporter.log("--- Browser launched successfully: "+ BROWSER + " ---", true);
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
//			System.out.println("--- Browser launched successfully: "+ BROWSER + " ---");
			Reporter.log("--- Browser launched successfully: "+ BROWSER + " ---", true);
		}
		else
		{
//			System.out.println("Enter valid Browser Name");
			Reporter.log("Enter valid Browser Name", true);
		}
		
		sDriver = driver;
		wLib.maximiseWindow(driver);
		wLib.waitForPageLoad(driver);
		driver.get(URL);
		
	}
	
	@BeforeMethod(groups = {"smokeSuite", "regressionSuite"})
	public void bmConfig() throws IOException
	{
		String USERNAME = pLib.readDataFromPropertyFile("username");
		String PASSWORD = pLib.readDataFromPropertyFile("password");
		
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
//		System.out.println("--- login is successful ---");
		Reporter.log("--- login is successful ---", true);
	}
	
	@AfterMethod(groups = {"smokeSuite", "regressionSuite"})
	public void amConfig()
	{
		HomePage hp = new HomePage(driver);
		hp.signOutOfApp(driver);
//		System.out.println("--- logout successful ---");
		Reporter.log("--- logout successful ---", true);
	}
	
//	@AfterTest
	@AfterClass(groups = {"smokeSuite", "regressionSuite"})
	public void acConfig()
	{
		driver.quit();
//		System.out.println("--- browser closed successfully ---");
		Reporter.log("--- browser closed successfully ---", true);
	}
	
	@AfterSuite(groups = {"smokeSuite", "regressionSuite"})
	public void asConfig()
	{
//		System.out.println("DataBase closed successfully");
		Reporter.log("DataBase closed successfully", true);
	}
	
}
