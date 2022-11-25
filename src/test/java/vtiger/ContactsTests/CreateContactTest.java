package vtiger.ContactsTests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import vtiger.GenericLibrary.BaseClass;
import vtiger.ObjectRepository.ContactsInfoPage;
import vtiger.ObjectRepository.ContactsPage;
import vtiger.ObjectRepository.CreateNewContactPage;
import vtiger.ObjectRepository.HomePage;

@Listeners(vtiger.GenericLibrary.ListenerImplementationLibrary.class)
public class CreateContactTest extends BaseClass {

	@Test(groups = "smokeSuite")
	public void createContactTest() throws IOException {

		// Step 2: read all the required data
		String lastName = eLib.readDataFromExcel("Contacts", 1, 2) + jLib.getRandomNumber();

		// Step 5: Navigate to Contacts Link
		HomePage hp = new HomePage(driver);
		hp.clickOnContacts();
		Reporter.log("Clicked on the contacts link",true);
//		Assert.fail();

		// Step 6: Navigate to create Contact Look up image
		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnCreateContactImg();
		Reporter.log("Clicked on the contacts look up image",true);

		// Step 7: create contact with mandatory details and save
		CreateNewContactPage ccp = new CreateNewContactPage(driver);
		ccp.createNewContact(lastName);
		Reporter.log(lastName+" contact created",true);

		// Step 8: Validate
		ContactsInfoPage cip = new ContactsInfoPage(driver);
		String contactHeader = cip.getContactHeader();
		System.out.println(contactHeader);
		Assert.assertTrue(contactHeader.contains(lastName), "Contact created ");

	}
	
	@Test(groups={"regressionSuite", "smokeSuite"})
	public void createContactDemoTest() throws InterruptedException
	{
		Thread.sleep(10000);
		Reporter.log("Demo test created",true);
		Assert.fail();
	}
	
	@Test
	public void createContactwithLeadSourceTest() throws InterruptedException
	{
		Thread.sleep(10000);
		Reporter.log("Lead source created",true);
//		Assert.fail();
	}
	
	@Test
	public void createContactwithLeadSourceAndOrgTest() throws InterruptedException
	{
		Thread.sleep(10000);
		Reporter.log("Lead source with org created",true);
	}

}
