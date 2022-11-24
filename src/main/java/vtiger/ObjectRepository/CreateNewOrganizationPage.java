package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericLibrary.WebDriverLibrary;

public class CreateNewOrganizationPage extends WebDriverLibrary{
	
	//Declaration
	@FindBy(name = "accountname")
	private WebElement organizationNameEdt;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(name = "industry")
	private WebElement industryDropDown;
	
	@FindBy(name = "accounttype")
	private WebElement typeDropDown;
	
	//Initialization
	public CreateNewOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getOrganizationNameEdt() {
		return organizationNameEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	//Business Library
	
	/**
	 * This method will create new organization with organization name
	 * @param organizationName
	 */
	public void createNewOrg(String organizationName)
	{
		organizationNameEdt.sendKeys(organizationName);
		saveBtn.click();
	}
	
	/**
	 * This method will create new organization with industry
	 * @param orgName
	 * @param IndustryType
	 */
	public void createNewOrg(String orgName, String IndustryType)
	{
		organizationNameEdt.sendKeys(orgName);
		handleDropdown(IndustryType, industryDropDown);
		saveBtn.click();
	}
	
	/**
	 * This method will create new organization with industry and type
	 * @param orgName
	 * @param IndustryType
	 * @param acountType
	 */
	public void createNewOrg(String orgName, String IndustryType, String acountType)
	{
		organizationNameEdt.sendKeys(orgName);
		handleDropdown(industryDropDown, IndustryType);
		handleDropdown(industryDropDown, acountType);
		saveBtn.click();
	}
	

}
