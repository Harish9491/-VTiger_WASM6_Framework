package vtiger.Practice;

import org.testng.annotations.Test;

public class ReadDataFromCMDline {
	
	@Test
	public void readData()
	{
		String BROWSER = System.getProperty("browser");
		String USERNAME = System.getProperty("username");
		String PASSWORD = System.getProperty("password");
		
		System.out.println("Browser given is --> "+BROWSER);
		System.out.println("Username given is --> "+USERNAME);
		System.out.println("Password given is --> "+PASSWORD);
	}

}
