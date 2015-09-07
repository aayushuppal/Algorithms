package designAllergy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AllergyUtil {
	static int idCount = 0;
	static Set<String> patientsList = new HashSet<String>();
	static Map<String, Patient> patientObjMap = new HashMap<String, Patient>();
	// other things like logger
	
	public static void updateOverallRecords(Patient p) {
		patientsList.add(p.patientName);
		patientObjMap.put(, p);
	}
}
