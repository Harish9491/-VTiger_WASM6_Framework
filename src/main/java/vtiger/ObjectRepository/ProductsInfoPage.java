package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsInfoPage {
	
	//Declaration
	@FindBy(xpath = "//span[@class='lvtHeaderText']")
	private WebElement productHeaderText;
	
	//Initialization
	public ProductsInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getContactHeaderText() {
		return productHeaderText;
	}
	
	//Business Library
	
	/**
	 * This method gets the header text and return to the caller
	 * @return
	 */
	public String getContactHeader()
	{
		return productHeaderText.getText();
	}

}
