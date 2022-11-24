package vtiger.OrganizationsTests;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import vtiger.GenericLibrary.BaseClass;
import vtiger.ObjectRepository.CreateNewOrganizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.OrganizationInfoPage;
import vtiger.ObjectRepository.OrganizationsPage;

@Listeners(vtiger.GenericLibrary.ListenerImplementationLibrary.class)
public class CreateMultipleOrganizationsWithIndustryTest extends BaseClass {

	@Test(dataProvider = "MultipleOrganization")
	public void createMultipleOrganizationsWithIndustryTest(String orgnizationName, String IndustryType)
			throws IOException {

		String orgName = orgnizationName + jLib.getRandomNumber();

		HomePage hp = new HomePage(driver);
		hp.clickOnOrganization();
		Reporter.log("clicked on organization link",true);

		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnCreateOrganizationImg();
		Reporter.log("clicked on organization lookup image",true);

		CreateNewOrganizationPage cop = new CreateNewOrganizationPage(driver);
		cop.createNewOrg(orgName, IndustryType);
		Reporter.log(orgName+" created with "+IndustryType+" dropdown",true);

		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String orgHeader = oip.getOrganizationHeader();
		Reporter.log(orgHeader,true);
		System.out.println(orgHeader);
		Assert.assertTrue(orgHeader.contains(orgName), "Organization created successfully");

	}

	@DataProvider(name = "MultipleOrganization")
	public Object[][] getData() throws EncryptedDocumentException, IOException {
		
		Object[][] data = eLib.readMultibleData("MultipleOrganization");
		return data;

	}

}
