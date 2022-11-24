package vtiger.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericLibrary.WebDriverLibrary;

public class CreateNewProductPage extends WebDriverLibrary {
	
	//Declaration
	@FindBy(name = "productname")
	private WebElement productnameEdt;
	
	@FindBy(xpath = "//img[@alt='Select']")
	private WebElement vendorImg;
	
	@FindBy(name = "search_text")
	private WebElement searchEdt;
	
	@FindBy(name = "search")
	private WebElement searchBtn;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	//Initialization
	public CreateNewProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public WebElement getProductnameEdt() {
		return productnameEdt;
	}

	public WebElement getVendorImg() {
		return vendorImg;
	}

	public WebElement getSearchEdt() {
		return searchEdt;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	//Business Libraries
	
	/**
	 * This method will create new product with product name
	 * @param lastName
	 */
	public void createNewProduct(String productname)
	{
		productnameEdt.sendKeys(productname);
		saveBtn.click();
	}
	
	
	/**
	 * This method will create new product with vendor
	 * @param lastName
	 * @param orgName
	 * @param driver
	 */
	public void createNewProduct(String productname,String vendorName, WebDriver driver)
	{
		productnameEdt.sendKeys(productname);
		vendorImg.click();
		switchToWindow(driver, "Vendors");
		searchEdt.sendKeys(vendorName);
		searchBtn.click();
		driver.findElement(By.xpath("//a[text()='"+vendorName+"']")).click();
		switchToWindow(driver, "Products");
		saveBtn.click();
	}
	
}
