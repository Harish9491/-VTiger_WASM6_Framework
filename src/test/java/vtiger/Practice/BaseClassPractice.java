package vtiger.Practice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class BaseClassPractice {
	
	@BeforeClass
	public void bcConfig()
	{
		System.out.println("@BeforeClass");
	}
	
	@BeforeSuite
	public void bsConfig()
	{
		System.out.println("@BeforeSuite");
	}
	
	@BeforeMethod
	public void bmConfig()
	{
		System.out.println("@BeforeMethod");
	}
	
	@Test
	public void meth1Config()
	{
		System.out.println("method 1");
	}
	
	@Test
	public void meth2Config()
	{
		System.out.println("method 2");
	}
	
	@Test
	public void meth3Config()
	{
		System.out.println("method 3");
	}
	
	@AfterClass
	public void acConfig()
	{
		System.out.println("@AfterClass");
	}
	
	@AfterSuite
	public void asConfig()
	{
		System.out.println("@AfterSuite");
	}
	
	@AfterMethod
	public void amConfig()
	{
		System.out.println("@AfterMethod");
	}

}
