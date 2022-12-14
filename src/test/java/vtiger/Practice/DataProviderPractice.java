package vtiger.Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice {

	@Test(dataProvider = "Phones")
	public void addProductToCartTest(String name, String model, int price, int qty)
	{
		System.out.println("Price: "+name+" Model: "+model+" Price: "+price+" Quantity: "+qty);
	}
	
	@DataProvider(name = "Phones")
	public Object[][] getData()
	{
		Object[][] data = new Object[3][4];
		
		data[0][0] = "samsung";
		data[0][1] = "A80";
		data[0][2] = 25000;
		data[0][3] = 10;

		data[1][0] = "Iphone";
		data[1][1] = "11Pro";
		data[1][2] = 5000;
		data[1][3] = 5;

		data[2][0] = "Vivi";
		data[2][1] = "y21";
		data[2][2] = 10000;
		data[2][3] = 15;
		
		return data;
		
	}
	
	
}
