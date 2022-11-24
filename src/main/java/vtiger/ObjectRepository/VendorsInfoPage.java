package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorsInfoPage {
	
	//Declaration
		@FindBy(xpath = "//span[@class='lvtHeaderText']")
		private WebElement vendorHeaderText;
		
		//Initialization
		public VendorsInfoPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}

		//Utilization
		public WebElement getVendorHeaderText() {
			return vendorHeaderText;
		}
		
		//Business Library
		
		/**
		 * This method gets the header text and return to the caller
		 * @return
		 */
		public String getVendorHeader()
		{
			return vendorHeaderText.getText();
		}

}
