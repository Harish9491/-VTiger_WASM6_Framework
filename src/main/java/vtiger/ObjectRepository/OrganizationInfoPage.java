package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {
	
	//Declaration
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement organizationHeaderText;

	//Initialization
	public OrganizationInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public WebElement getOrganizationHeaderText() {
		return organizationHeaderText;
	}
	
	//Business Library
	
	/**
	 * This method gets the header text and return to the caller
	 * @return
	 */
	public String getOrganizationHeader()
	{
		return organizationHeaderText.getText();
	}

}
