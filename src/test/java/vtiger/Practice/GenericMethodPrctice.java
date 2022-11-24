package vtiger.Practice;

import java.io.IOException;

import vtiger.GenericLibrary.ExcelFileLibrary;
import vtiger.GenericLibrary.JavaLibrary;
import vtiger.GenericLibrary.PropertyFileLibrary;

public class GenericMethodPrctice {

	public static void main(String[] args) throws IOException {
		
		JavaLibrary jLib = new JavaLibrary();
		PropertyFileLibrary pLib = new PropertyFileLibrary();
		ExcelFileLibrary eLib = new ExcelFileLibrary();
		
		String date = jLib.getSystemDate();
		System.out.println(date);
		String formatedDate = jLib.getSystemDateInFormat();
		System.out.println(formatedDate);
		
		
		String browser = pLib.readDataFromPropertyFile("browser");
		System.out.println(browser);
		String username = pLib.readDataFromPropertyFile("username");
		System.out.println(username);
		
		String val = eLib.readDataFromExcel("Contacts", 1, 2);
		System.out.println(val);
		int rowCount = eLib.getRowCount("Contacts");
		System.out.println(rowCount);
		eLib.writeDataIntoExcel("Contacts", rowCount, 6, val);
	}

}
