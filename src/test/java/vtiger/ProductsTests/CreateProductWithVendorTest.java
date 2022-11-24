package vtiger.ProductsTests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import vtiger.GenericLibrary.BaseClass;
import vtiger.ObjectRepository.CreateNewProductPage;
import vtiger.ObjectRepository.CreateNewVendorPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.ProductsInfoPage;
import vtiger.ObjectRepository.ProductsPage;
import vtiger.ObjectRepository.VendorsInfoPage;
import vtiger.ObjectRepository.VendorsPage;

@Listeners(vtiger.GenericLibrary.ListenerImplementationLibrary.class)
public class CreateProductWithVendorTest extends BaseClass {

	@Test
	public void createProductWithVendorTest() throws IOException {
		
		
		String productName = eLib.readDataFromExcel("Products", 1, 2) + jLib.getRandomNumber();
		String vendorName = eLib.readDataFromExcel("Products", 1, 3) + jLib.getRandomNumber();
		
		//Step 5: Navigate to Vendors link
		HomePage hp = new HomePage(driver);
		hp.clickOnVendors(driver);
		Reporter.log("clicked on vendor link",true);
		
		//Step 6: Navigate to create Vendors look up image
		VendorsPage vp = new VendorsPage(driver);
		vp.clickOnCreateVendorImg();
		Reporter.log("clicked on vendor lookup image",true);
		
		//Step 7: Create new vendor and save
		CreateNewVendorPage cvp = new CreateNewVendorPage(driver);
		cvp.createNewContact(vendorName);
		Reporter.log(vendorName+" vendor created",true);
		
		VendorsInfoPage vip = new VendorsInfoPage(driver);
		String vendorHeader = vip.getVendorHeader();
		Reporter.log(vendorHeader,true);
		Assert.assertTrue(vendorHeader.contains(vendorName), "Vendor created successfully");
		
		hp.clickOnProducts();
		Reporter.log("clicked on oproduct link",true);
		
		ProductsPage pp = new ProductsPage(driver);
		pp.clickOnCreateProductImg();
		Reporter.log("clicked on products lookup image",true);
		
		CreateNewProductPage cnp = new CreateNewProductPage(driver);
		cnp.createNewProduct(productName, vendorName, driver);
		Reporter.log(productName + " product created with "+vendorName+" vendor",true);
		
		ProductsInfoPage pip = new ProductsInfoPage(driver);
		String productHeader = pip.getContactHeader();
		Reporter.log(productHeader,true);
		Assert.assertTrue(productHeader.contains(productName), "product created");
		
	}

}
