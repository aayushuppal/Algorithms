package designAllergy;

import java.util.regex.*;

public class PhoneNumber {
	String phoneNum; //format  (xxx)-xxx-xxxx
	
	@SuppressWarnings("serial")
	public static class PhoneNumberException extends RuntimeException
	{
		public PhoneNumberException(String msg)
		{
			super(msg+"  is invalid phone number entry");
		}
	}
	
	public PhoneNumber(String pNo) throws PhoneNumberException{
		Pattern numPattern = Pattern.compile("\\d");
		Matcher match = numPattern.matcher(pNo);
		String temp = "";
		while (match.find()) {
			temp +=match.group();
		}
		if (temp.length() !=10) {
			throw new PhoneNumberException(pNo); 
		}
		
		this.phoneNum = String.format("(%s)-%s-%s",temp.substring(0, 3), temp.substring(3, 6), temp.substring(6, 10));
		
	}
	
	public String getPhoneVal () {
		return this.phoneNum;
	}

}
