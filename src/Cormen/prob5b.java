package Cormen;

//using string buffer - not needed here

import java.util.Scanner;

public class prob5b {

	public static void main(String[] args) {
		prob5b pob = new prob5b();
		System.out.println("input string here:");
		Scanner inp = new Scanner(System.in);
		String str = inp.nextLine();
		inp.close();
		
		System.out.println(pob.StCompress(str));
	}
	
	public String StCompress(String str){
		String otpt ="";
		return otpt;
	}

}
