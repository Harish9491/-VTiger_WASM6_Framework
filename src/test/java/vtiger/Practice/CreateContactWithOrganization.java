package vtiger.Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateContactWithOrganization {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\commonData.properties");
		Properties p = new Properties();
		p.load(fis);
		String browser = p.getProperty("browser");
		WebDriver driver;
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		} 
		else if(browser.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		} 
		else
		{
			driver = new ChromeDriver();
		}
		 
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.name("user_name")).sendKeys(p.getProperty("username"));
		driver.findElement(By.name("user_password")).sendKeys(p.getProperty("password"));
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys("TestYantra3");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Thread.sleep(5000);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement contact = driver.findElement(By.linkText("Contacts"));
		wait.until(ExpectedConditions.elementToBeClickable(contact)).click();
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys("Kosuri");
		String parent = driver.getWindowHandle();
		driver.findElement(By.xpath("//img[@alt='Select']")).click();
		
		Set<String> child = driver.getWindowHandles();
		for (String string : child) {
			driver.switchTo().window(string);
		}	
		driver.findElement(By.xpath("//a[text()='TestYantra3']")).click();
		driver.switchTo().window(parent);
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
//		Thread.sleep(5000);
		
		Actions a = new Actions(driver);
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		a.moveToElement(ele).perform();
		driver.findElement(By.linkText("Sign Out")).click();

	}

}
