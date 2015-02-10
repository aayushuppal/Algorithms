package Cormen;
/* Given two strings, write a method to decide if one is a permutation of the other
Aayush Uppal - http://uppalaayush.wordpress.com/profile */
import java.util.*;
import java.util.Arrays;

public class prob3{
	
	public static void main(String[] args){
	prob3 pobj = new prob3();
	System.out.println("Check if a permuation:");
	Scanner inp = new Scanner(System.in);	
	
	String St1 = inp.nextLine();
	String St2 = inp.nextLine();
	
	inp.close();
	System.out.println(pobj.CheckPerm(St1,St2));
	
	}
	
	public boolean CheckPerm(String a, String b){
	boolean otpt = false;	
	
		if (a.length() != b.length()){
			return otpt;
		}
		else{
			int[] letters1 = new int[256];  //because 256 ascii characters.
			int[] letters2 = new int[256];  //because 256 ascii characters.
			
			char[] x = a.toCharArray();
			char[] y = b.toCharArray();
			
			for (char c :  x)  {  // count number of each char in s.
				letters1[c]++;
				}
			for (char c :  y)  {  // count number of each char in s.
				letters2[c]++;
				}
			if (Arrays.equals(letters1, letters2)){
				otpt = true;
			}
			
			/*
			Arrays.sort(x);
			Arrays.sort(y);
			if (Arrays.equals(x, y)){
				otpt = true;
			}
			*/
			return otpt;	
		}	
	}
	
	
}