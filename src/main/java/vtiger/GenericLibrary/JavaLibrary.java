package vtiger.GenericLibrary;

import java.util.Date;
import java.util.Random;

/**
 * This class will contain all the generic methods related to java
 * @author Harish
 *
 */
public class JavaLibrary {
	
	/**
	 * This method will generate random number for every execution.
	 * @return
	 */
	public int getRandomNumber()
	{
		Random ran = new Random();
		int value = ran.nextInt(500);
		return value;
	}

	/**
	 * This method will generate the system date
	 * @return
	 */
	public String getSystemDate()
	{
		Date d = new Date();
		String date = d.toString();
		return date;
	}
	
	/**
	 * This method will return the current system date in a specific format
	 * @return
	 */
	public String getSystemDateInFormat()
	{
		Date d = new Date();
		String[] date = d.toString().split(" ");
		String month = date[1];
		String day = date[2];
		String year = date[5];
		String time = date[3].replace(":", "-");
		String dateFormate = day+"-"+month+"-"+year+" "+time;
		return dateFormate;
	}

}
