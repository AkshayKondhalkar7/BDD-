package fp.base;

import com.github.javafaker.Faker;

public class FakeData {

	static Faker faker = new Faker();	
	
	
	public String getFirstName() 
	{
	return faker.name().firstName();
	}
	
	public String getLastName() {
		return faker.name().lastName();
	}
	
	public String getPhoneNumber() {
		return faker.phoneNumber().cellPhone();
	}
	
	public String getCompanyName() {
		return faker.company().name();
	}
	
	public static  String getFullName() {
		return faker.name().fullName();
	}
	
	
}
