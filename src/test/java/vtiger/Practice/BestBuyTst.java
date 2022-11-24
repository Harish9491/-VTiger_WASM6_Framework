package vtiger.Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BestBuyTst {
	
	@Test
	public void bestBy()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.bestbuy.ca/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20L));
		
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys("ipad");
		driver.findElement(By.xpath("//div[@class='autocompleteContainer_qfuGi']/descendant::li[5]")).click();
		driver.findElement(By.xpath("//input[@id='facetFilter-Online Only']")).click();
	}

}
