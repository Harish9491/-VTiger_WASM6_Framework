package vtiger.Practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;

import vtiger.GenericLibrary.ExcelFileLibrary;

public class MultiDataPractice {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		ExcelFileLibrary eLib = new ExcelFileLibrary();
		Object[][] data = eLib.readMultibleData("MultipleOrganization");
		int row = data.length;
		int column = data[0].length;
		System.out.println(row);
		System.out.println(column);
		System.out.println(eLib.getRowCount("MultipleOrganization"));

	}

}
