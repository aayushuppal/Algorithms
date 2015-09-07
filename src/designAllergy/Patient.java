package designAllergy;

import java.util.Date;
import java.util.Set;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Patient extends Person{
	int patientId;
	Date entryDate;
	private Set<String> AllergyList;
	// medicine plan
	
	public Patient (String Name, String phoneNum, String address, int age) {
		super(Name, phoneNum, address, age);
	}
	
	public static void main(String[] args) {
		Patient p1 = new Patient("aaa bbb", "1234567890", "address", 20);
		System.out.println(p1.firstName);
	}
}