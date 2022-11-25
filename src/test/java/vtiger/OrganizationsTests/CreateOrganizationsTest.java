package vtiger.OrganizationsTests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import vtiger.GenericLibrary.BaseClass;
import vtiger.ObjectRepository.CreateNewOrganizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.OrganizationInfoPage;
import vtiger.ObjectRepository.OrganizationsPage;

@Listeners(vtiger.GenericLibrary.ListenerImplementationLibrary.class)
public class CreateOrganizationsTest extends BaseClass {

	@Test(groups="regressionSuite")
	public void createOrganizationsTest() throws IOException, InterruptedException {

		String orgName = eLib.readDataFromExcel("organization", 1, 2) + jLib.getRandomNumber();

		HomePage hp = new HomePage(driver);
		hp.clickOnOrganization();
		Reporter.log("clicked on organization link", true);
		Assert.fail();

		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnCreateOrganizationImg();
		Reporter.log("clicked on organization lookup image", true);

		CreateNewOrganizationPage cop = new CreateNewOrganizationPage(driver);
		cop.createNewOrg(orgName);
		Reporter.log(orgName+" Organization created", true);

		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String orgHeader = oip.getOrganizationHeader();
//		System.out.println(orgHeader);
		Reporter.log(orgHeader, true);
		Assert.assertTrue(orgHeader.contains(orgName), "organization created");

	}

}
