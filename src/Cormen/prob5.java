package Cormen;
/*String compression problem
 time O(n) space O(n) solution */
import java.util.Arrays;
import java.util.Scanner;

public class prob5 {

	public static void main(String[] args) {
		System.out.println("input string");
		Scanner inp = new Scanner(System.in);
		String str = inp.nextLine();
		inp.close();
		
		char[] cArr = str.toCharArray();
		//Arrays.sort(cArr); //use if condensed output needed character wise
		String otp = "";
		char base = '\0';
		int ct = 0;
		
		for (int i=0; i<cArr.length; i++){
			int sflag = 0;
			
			if(i==0||sflag==0){
				base = cArr[i];
				ct = 0;
				sflag = 1;
			}
			while(cArr[i] == base){
				ct++;
				if(i <cArr.length-1){i++;}
				else{break;}
			}
			otp = otp +base+ct;
			if (cArr[cArr.length-1] != base){i--;}
			 
					
		}
		System.out.println(otp);
	}

}
