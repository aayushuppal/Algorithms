package Cormen;

// using the regex approach

import java.util.regex.*;
import java.util.Scanner;

public class prob4{
	
		public static void main(String[] args){
		prob4 pob = new prob4();
		System.out.println("input string");
		Scanner inp = new Scanner(System.in);
		String str = inp.nextLine();
		inp.close();
		
		str = pob.repWhit(str);
		System.out.println(str);
		}
		
		public String repWhit(String str){
			Pattern pat1 = Pattern.compile("\\s");
			Matcher mat1 = pat1.matcher(str);
			str = mat1.replaceAll("%20");
			return str;
		} 
	
}