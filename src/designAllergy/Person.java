package designAllergy;

import designAllergy.PhoneNumber.PhoneNumberException;

public class Person {
	String firstName;
	String lastName;
	String address;
	int age;
	PhoneNumber phoneNumber;
	
	Person (String Name, String phoneNum, String address, int age) throws PhoneNumberException{
		String arr[] = Name.split(" ");
		this.firstName = arr[0];
		this.lastName = arr[1];
		this.address = address;
		this.age = age;
		this.phoneNumber = new PhoneNumber(phoneNum);
	}
	
}
