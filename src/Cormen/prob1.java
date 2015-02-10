package Cormen;

import java.util.*;

public class prob1 {
	static char[] bChar = null;
	static int count = 0;
	static char temp = '0';
	static int fin = 0;
	
	public static void main(String[] args) {
	Scanner inputScan = new Scanner(System.in);
	System.out.println("// only lower case alphabets");
	
	System.out.println("input string");
	String str = inputScan.nextLine();
	double ctr = 0;
	char[] cArr = new char[str.length()];
	cArr = str.toCharArray();
	
	for (char c:cArr){
	int ac = (int) c;
	ac = ac - 97;
	count++;
	
	if (count == 1){
		ctr = ctr + Math.pow(2,ac);
		int ty = (int) ctr;
		String asd = Integer.toBinaryString(ty);	
		String asdn = new StringBuilder(new String(asd)).reverse().toString();
		bChar = asdn.toCharArray();
	}
	else {
		try {temp = bChar[ac]; }
		catch (Exception e){
			temp = '0';
		}
		if(temp == '1'){
			fin = 0;
			break;	
		}
		else {
			ctr = ctr + Math.pow(2,ac);
			int ty = (int) ctr;
			String asd = Integer.toBinaryString(ty);
			String asdn = new StringBuilder(new String(asd)).reverse().toString();
			bChar = asdn.toCharArray();
			fin = 1;
		}
	}
	}
	if (fin == 0){
		System.out.println("repetition found");
	}
	else{
		System.out.println("no repetition found");
	}
	inputScan.close();
	
	}

}
