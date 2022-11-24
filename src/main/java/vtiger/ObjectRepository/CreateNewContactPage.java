package vtiger.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericLibrary.WebDriverLibrary;

public class CreateNewContactPage extends WebDriverLibrary{
	
	//Declaration
	@FindBy(name = "lastname")
	private WebElement lastNameEdt;
	
	@FindBy(name = "leadsource")
	private WebElement leadSourceDropDown;
	
	@FindBy(xpath = "//input[@name='account_id']/following-sibling::img[@alt='Select']")
	private WebElement organizationImg;
	
	@FindBy(name = "search_text")
	private WebElement searchEdt;
	
	@FindBy(name = "search")
	private WebElement searchBtn;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	//Initialization
	public CreateNewContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public WebElement getLastNameEdt() {
		return lastNameEdt;
	}

	public WebElement getLeadSourceDropDown() {
		return leadSourceDropDown;
	}

	public WebElement getOrganizationImg() {
		return organizationImg;
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
	 * This method will create new contact with last name
	 * @param lastName
	 */
	public void createNewContact(String lastName)
	{
		lastNameEdt.sendKeys(lastName);
		saveBtn.click();
	}
	
	/**
	 * This method will create new contact with lead source drop-down
	 * @param lastName
	 * @param leadSourceValue
	 */
	public void createNewContact(String lastName, String leadSourceValue)
	{
		lastNameEdt.sendKeys(lastName);
		handleDropdown(leadSourceDropDown, leadSourceValue);
		saveBtn.click();
	}
	
	/**
	 * This method will create new contact with organization
	 * @param lastName
	 * @param orgName
	 * @param driver
	 */
	public void createNewContact(String lastName,String orgName, WebDriver driver)
	{
		lastNameEdt.sendKeys(lastName);
		organizationImg.click();
		switchToWindow(driver, "Accounts");
		searchEdt.sendKeys(orgName);
		searchBtn.click();
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		switchToWindow(driver, "Contacts");
		saveBtn.click();
	}

}
