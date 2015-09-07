package designAllergy;

import designAllergy.Allergy.SEVERITY;

public class medicineFrequency {
	public  static enum TIME_SLOT { DAILY, ALTERNATE, WEEKLY, MONTHLY};
	int pillAmount;
	TIME_SLOT timeSlot;
	
	public medicineFrequency(SEVERITY sev) {
		switch (sev) {
		case LOW: 
			this.pillAmount = 2;
			this.timeSlot = TIME_SLOT.WEEKLY;
			break;
		case MODERATE: 
			this.pillAmount = 4;
			this.timeSlot = TIME_SLOT.ALTERNATE;
			break;
		case FATAL: 
			this.pillAmount = 3;
			this.timeSlot = TIME_SLOT.DAILY;
			break;
		default:
			break;
		}
	}
	

}
