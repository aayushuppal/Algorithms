package designAllergy;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class Allergy { 
	public static Map<String, Allergy> recognisedAllergiesMap = new HashMap<String, Allergy>(); // because less number of allergies 
	public static enum SEVERITY { LOW, // infection [0,20)% 
							   MODERATE, // infection [20-40)%
							   FATAL };  // infection >40%
	
	private Person reporter;
	private Set<String> patientIdSet;						// patients can be huge hence hashset & instance variable
	private Map<String,SEVERITY> patientToSeverityMap;
	private Map<String, SEVERITY> symptomToSeverityMap;
	

	private Allergy(String allergyName, String personName, String phoneNum, String address, int age, Map<String, SEVERITY> Symptoms) {
		this.reporter = new Person(personName, phoneNum, address, age);
		if (this.symptomToSeverityMap == null) {
			this.symptomToSeverityMap 
		}
		this.recognisedAllergiesMap.put(allergyName, value)
	}
	
	public void registerNewAllergy(String allergyName, String personName, String phoneNum, String address, int age, 
									Map<String, SEVERITY> Symptoms) {
		if (!recognisedAllergiesMap.keySet().contains(allergyName)) {
		Allergy temp = new Allergy(allergyName, personName, phoneNum, address, age, Symptoms);
		
		} else {
			System.out.println("failed to register, already exists");
		}
	}
	
	public Allergy getAllergyDat(String allergyName) {
		if (!recognisedAllergiesMap.keySet().contains(allergyName)) {
			return null;
		} else {
			return recognisedAllergiesMap.get(allergyName);
		}
	}
	

}




