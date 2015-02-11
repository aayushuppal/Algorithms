package RegEx;
import java.util.regex.*;

public class regexTest {

	public static void main(String[] args) {
		
		/* This code block checks a pattern and splits a string around it 
		 * including the end of string in it's pattern too. 
		 * Also returns count of regex / the pattern itself
		 * replaces the pattern as well
		*/
		String input = "AFSTHANSGVAHabcAJANDNMANabcAKJNASKS";
		//input = input.replaceAll("abc", "def");
		//System.out.println(input);
		
		Pattern p1 = Pattern.compile("abc|$");
		Matcher m1 = p1.matcher(input);
		
		int startPoint = 0; 
		while(m1.find()){
			System.out.println(input.substring(startPoint,m1.start()));
			startPoint = m1.end();
			// 		System.out.println(m1.group()); // for returning the pattern itself
		}
		
		

	}

}
