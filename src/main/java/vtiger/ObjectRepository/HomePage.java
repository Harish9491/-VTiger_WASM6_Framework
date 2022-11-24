package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericLibrary.WebDriverLibrary;

public class HomePage extends WebDriverLibrary{
	
	//Declaration
	@FindBy(linkText = "Organizations")
	private WebElement organizationLink;
	
	@FindBy(linkText = "Contacts")
	private WebElement contactsLink;
	
	@FindBy(linkText = "Products")
	private WebElement productsLink;
	
	@FindBy(linkText = "Opportunities")
	private WebElement opportunitiesLink;
	
	@FindBy(linkText = "More")
	private WebElement moreHover;
	
	@FindBy(linkText = "Vendors")
	private WebElement vendorsLink;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorImg;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signOutLink;
	
	//Initialization
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public WebElement getOrganizationLink() {
		return organizationLink;
	}

	public WebElement getContactsLink() {
		return contactsLink;
	}

	public WebElement getProductsLink() {
		return productsLink;
	}

	public WebElement getOpportunitiesLink() {
		return opportunitiesLink;
	}


	public WebElement getMoreHover() {
		return moreHover;
	}
	
	public WebElement getVendorsLink() {
		return vendorsLink;
	}
	
	public WebElement getAdministratorImg() {
		return administratorImg;
	}
	
	public WebElement getSignOutLink() {
		return signOutLink;
	}
	
	//Business Library
	
	/**
	 * This method will click on the Organizations link
	 */
	public void clickOnOrganization()
	{
		organizationLink.click();
	}
	
	/**
	 * This method will click on the Contacts link
	 */
	public void clickOnContacts()
	{
		contactsLink.click();
	}
	
	/**
	 * This method will click on the Products link
	 */
	public void clickOnProducts()
	{
		productsLink.click();
	}
	
	/**
	 * This method will click on the Opportunities link
	 */
	public void clickOnOpportunities()
	{
		opportunitiesLink.click();
	}
	
	public void clickOnVendors(WebDriver driver)
	{
		mouseHoverOn(driver, moreHover);
		vendorsLink.click();
	}
	
	/**
	 * This method perform sign out of the application
	 * @param driver
	 */
	public void signOutOfApp(WebDriver driver)
	{
		mouseHoverOn(driver, administratorImg);
		signOutLink.click();
	}
	
}
