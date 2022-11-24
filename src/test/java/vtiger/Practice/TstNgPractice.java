package vtiger.Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TstNgPractice {
	
	@Test(priority = 1, invocationCount = 3)
	public void createContact()
	{
		System.out.println("customer created");
	}
	
	@Test(dependsOnMethods = "createContact")
	public void modifyContact()
	{
		Assert.fail();
		System.out.println("customer modified");
	}
	
	@Test(priority = -1, dependsOnMethods = {"createContact", "modifyContact"}, enabled = false)
	public void deleteContact()
	{
		System.out.println("customer deleted");
	}

}
