package fp.base;

import java.util.Random;

public class CreateRandomNumbers
{
	static Random random = new Random();


	public static String randomizePhoneNo() {

		int number = random.nextInt(9999999);
		return "967" + String.format("%07d", number);
	}

	public static String randomNumber() {

		int number = random.nextInt(1000);
		return   Integer.toString(number);
	}

	

}
