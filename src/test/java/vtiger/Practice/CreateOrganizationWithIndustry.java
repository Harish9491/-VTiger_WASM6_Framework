package vtiger.Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateOrganizationWithIndustry {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\commonData.properties");
		Properties p = new Properties();
		p.load(fis);
		String browser = p.getProperty("browser");
		String username = p.getProperty("username");
		String password = p.getProperty("password");
		String url = p.getProperty("url");
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
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys("Qspiders11");
		WebElement dropdown = driver.findElement(By.name("industry"));
		Select s = new Select(dropdown);
		s.selectByValue("Healthcare");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Thread.sleep(5000);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Actions a = new Actions(driver);
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wait.until(ExpectedConditions.visibilityOf(ele));
		a.moveToElement(ele).perform();
		WebElement logout = driver.findElement(By.xpath("//a[text()='Sign Out']"));
		wait.until(ExpectedConditions.elementToBeClickable(logout));
		logout.click();

	}

}
