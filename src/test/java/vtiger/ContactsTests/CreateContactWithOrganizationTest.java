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
import vtiger.ObjectRepository.CreateNewOrganizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.OrganizationInfoPage;
import vtiger.ObjectRepository.OrganizationsPage;

@Listeners(vtiger.GenericLibrary.ListenerImplementationLibrary.class)
public class CreateContactWithOrganizationTest extends BaseClass {

	@Test(groups = "regressionSuite")
	public void createContactWithOrganizationTest() throws IOException {

		// Step 2: read all the required data
		String orgName = eLib.readDataFromExcel("Contacts", 4, 3) + jLib.getRandomNumber();
		String lastName = eLib.readDataFromExcel("Contacts", 4, 2) + jLib.getRandomNumber();

		// Step 5: Navigate to Organizations link
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganization();
		Reporter.log("clicked on organization link", true);
//		Assert.fail();

		// Step 6: Navigate to create Organizations look up image
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnCreateOrganizationImg();
		Reporter.log("clicked on organization lookup image", true);
//		Assert.fail();

		// Step 7: Create new organization and save
		CreateNewOrganizationPage cno = new CreateNewOrganizationPage(driver);
		cno.createNewOrg(orgName);
		Reporter.log(orgName+" organization created", true);

		// Step 8: Validate for Organization
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String orgHeader = oip.getOrganizationHeader();
//		System.out.println(orgHeader);
		Reporter.log(orgHeader, true);
		Assert.assertTrue(orgHeader.contains(orgName), "Organization created ");
		// Step 9: Navigate to contacts link
		hp.clickOnContacts();
		Reporter.log("clicked on contacts link", true);

		// Step 10: Navigate to create Contact Look up image
		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnCreateContactImg();
		Reporter.log("clicked on contacts lookup image", true);

		// Step 11: create contact with mandatory details
		CreateNewContactPage cnc = new CreateNewContactPage(driver);
		cnc.createNewContact(lastName, orgName, driver);
		Reporter.log(lastName+" contact created with "+orgName+" organization", true);

		// Step 12: Validate for Contact
		ContactsInfoPage cip = new ContactsInfoPage(driver);
		String contactHeader = cip.getContactHeader();
//		System.out.println(contactHeader);
		Reporter.log(contactHeader, true);
		Assert.assertTrue(contactHeader.contains(lastName), "Contact created ");

	}
}
