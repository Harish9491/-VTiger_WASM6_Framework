package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericLibrary.WebDriverLibrary;

public class CreateNewVendorPage extends WebDriverLibrary {
	
	//Declaration
		@FindBy(name = "vendorname")
		private WebElement vendornameEdt;
		
		@FindBy(xpath = "//input[@title='Save [Alt+S]']")
		private WebElement saveBtn;
		
		//Initialization
		public CreateNewVendorPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
		//Utilization
		public WebElement getvendornameEdt() {
			return vendornameEdt;
		}

		public WebElement getSaveBtn() {
			return saveBtn;
		}
		
		//Business Libraries
		
		/**
		 * This method will create new vendor with vendor name
		 * @param lastName
		 */
		public void createNewContact(String lastName)
		{
			vendornameEdt.sendKeys(lastName);
			saveBtn.click();
		}

}
