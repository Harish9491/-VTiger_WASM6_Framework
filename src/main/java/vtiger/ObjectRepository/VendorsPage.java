package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericLibrary.WebDriverLibrary;

public class VendorsPage extends WebDriverLibrary {
	
//	Declaration
	@FindBy(xpath = "//img[@alt='Create Vendor...']")
	private WebElement createVendorLookUpImg;
	
	//Initialization
	public VendorsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public WebElement getCreateVendorLookUpImg() {
		return createVendorLookUpImg;
	}
	
	//Business library
	
	/**
	 * This method will click on create Vendor look up image
	 */
	public void clickOnCreateVendorImg()
	{
		createVendorLookUpImg.click();
	}

}
