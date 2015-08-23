package String;

import java.util.BitSet;
import java.util.Scanner;

public class allCharsAreUnique {
	
	
	// consider chars from 'a' to 'z'

	public static void main(String[] args) {
		System.out.println("enter string");
		Scanner scan = new Scanner(System.in);
		String inp = scan.nextLine();
		scan.close();
		
		System.out.println(usingInteger(inp));

	}
	
	public static boolean usingBitset(String inp) {
		BitSet b1 = new BitSet(32);
		for (int i=0; i<inp.length(); i++){
			if(b1.get(inp.charAt(i)-'a')) { 
				return false;
			}
			b1.set(inp.charAt(i)-'a');
		}
		return true;
	}
	
	public static boolean usingInteger(String inp) {
		int checker = 0;
		for (int i=0; i<inp.length(); i++) {
			int val = inp.charAt(i) - 'a';
			if ((checker & (1<<val)) > 0) {
				return false;
			}
			checker |= (1<<val);
		}
		System.out.println(Integer.toBinaryString(checker));
		return true;
	}

}
