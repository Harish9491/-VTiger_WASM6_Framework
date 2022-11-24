package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsInfoPage {
	
	//Declaration
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement contactHeaderText;
	
	//Initialization
	public ContactsInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getContactHeaderText() {
		return contactHeaderText;
	}
	
	//Business Library
	
	/**
	 * This method gets the header text and return to the caller
	 * @return
	 */
	public String getContactHeader()
	{
		return contactHeaderText.getText();
	}
	
}
