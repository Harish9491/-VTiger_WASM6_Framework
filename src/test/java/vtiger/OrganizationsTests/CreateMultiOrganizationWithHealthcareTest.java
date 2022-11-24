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
public class CreateMultiOrganizationWithHealthcareTest extends BaseClass {

	@Test(dataProvider = "orgData")
	public void createMultiOrganizationWithHealthcareTest(String orgnizationName) throws IOException {

		String orgName = orgnizationName + jLib.getRandomNumber();

		HomePage hp = new HomePage(driver);
		hp.clickOnOrganization();
		Reporter.log("click on organization link",true);

		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnCreateOrganizationImg();
		Reporter.log("click on organization lookup image",true);

		CreateNewOrganizationPage cop = new CreateNewOrganizationPage(driver);
		cop.createNewOrg(orgName, "Healthcare");
		Reporter.log(orgName+" organization created with Healthcare dropdown",true);

		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String orgHeader = oip.getOrganizationHeader();
		Reporter.log(orgHeader,true);
		Assert.assertTrue(orgHeader.contains(orgName), "Organization created ");

	}

	@DataProvider(name = "orgData")
	public Object[][] getData() throws EncryptedDocumentException, IOException {
		
//		Object[][] data = new Object[4][1];
//
//		data[0][0] = "Qspiders";
//		data[1][0] = "Allstates";
//		data[2][0] = "Wipro";
//		data[3][0] = "Infosys";
//
//		return data;
		
		Object[][] data = eLib.readMultibleData("MultipleOrganization");
		int length = data.length;
		Object[][] dataSend = new Object[length][1];
		for (int i = 0; i < length; i++) {
			
			dataSend[i][0] = data[i][0];
			
		}
		return dataSend;

	}

}
