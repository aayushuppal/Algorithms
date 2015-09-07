package designAllergy;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

public class UpdateUI {
	public static DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	

	public static void main(String[] args) {
		dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
		

	}

}
