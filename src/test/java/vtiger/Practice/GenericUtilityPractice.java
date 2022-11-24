package vtiger.Practice;

import java.util.Random;

public class GenericUtilityPractice {

	public static void main(String[] args) {
		
		Random ran = new Random();
		int random = ran.nextInt(500);
		System.out.println(random);
		
		int ran1 = ran.nextInt(100);
		int value = GenericUtilityPractice.add(random, ran1);
		System.out.println(ran1);
		System.out.println(value);
	}
	public static int add(int a, int b)
	{
		int c = a+b;
		return c;
	}

}
