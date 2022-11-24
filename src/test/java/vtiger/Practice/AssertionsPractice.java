package vtiger.Practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionsPractice {
	
	@Test
	public void demoTest()
	{
		SoftAssert sa = new SoftAssert();
		
		System.out.println("Step 1");
		System.out.println("Step 2");
		sa.assertEquals(9, 10, "created");
		
		System.out.println("Step 3");
		sa.assertTrue(false, "created ");
		
		System.out.println("Step 4");
		sa.assertAll();
	}
	
	@Test
	public void demo()
	{
		SoftAssert sa = new SoftAssert();
		
		System.out.println("Step 1");
		System.out.println("Step 2");
		sa.assertEquals(9, 9);
		
		System.out.println("Step 3");
		Assert.assertTrue(false, "created");
		
		System.out.println("Step 4");
		sa.assertAll();
	}

}
