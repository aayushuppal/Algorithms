package String;

import java.util.*;

public class strbuff {
	public static void main(String[] args) {
		Scanner userin = new Scanner(System.in);
		
		/*
		System.out.println("set the buffer base size");
		int BuffBase = userin.nextInt();
		userin.reset();
		*/
		
		System.out.println("input 3 strings");
		String[] stArr = new String[3];
		for (int i=0; i<3; i++){
			stArr[i] = userin.nextLine();
		}
		
		char[] art = new char[stArr[0].length()+stArr[1].length()+stArr[2].length()];
		//ArrayList<Character> cArrL = new ArrayList<Character>();
		
		int kl = 0;
		
		for(String s:stArr){
		char[] temp = s.toCharArray();
			for (int h=0; h<temp.length; h++){
				art[kl] = temp[h];
				kl++;
			}
		}
		
		String str = String.valueOf(art);
		System.out.println(str);
		userin.close();
	}

}