package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {
	
	//Declaration
	@FindBy(xpath = "//img[@alt='Create Organization...']")
	private WebElement createOrganizationLookUpImg;
	
	//Initialization
	public OrganizationsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getCreateOrganizationLookUpImg() {
		return createOrganizationLookUpImg;
	}
	
	//Business Library
	
	/**
	 * This metho will click on the create organization look up image
	 */
	public void clickOnCreateOrganizationImg()
	{
		createOrganizationLookUpImg.click();
	}

}
