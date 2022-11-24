package vtiger.Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFilePractice {
	
	public static void main(String[] args) throws IOException {
		
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\commonData.properties");
		Properties p = new Properties();
		p.load(fis);
		
		String url = p.getProperty("url");
		System.out.println(url);
		
		String browser = p.getProperty("browser");
		System.out.println(browser);
		
		String username = p.getProperty("username");
		System.out.println(username);
		
		String password = p.getProperty("password");
		System.out.println(password);
	}
}
