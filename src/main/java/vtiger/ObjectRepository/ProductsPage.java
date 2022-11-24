package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {
	
//	Declaration
	@FindBy(xpath = "//img[@alt='Create Product...']")
	private WebElement createProductLookUpImg;
	
	//Initialization
	public ProductsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public WebElement getCreateProductLookUpImg() {
		return createProductLookUpImg;
	}
	
	//Business library
	
	/**
	 * This method will click on create contact look up image
	 */
	public void clickOnCreateProductImg()
	{
		createProductLookUpImg.click();
	}

}
