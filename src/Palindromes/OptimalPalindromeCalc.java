package Palindromes;


import java.util.*;

public class OptimalPalindromeCalc {
	static char[] cArr2;
	static String a;
	public static void main(String[] args) {
	//Scanner s = new Scanner(System.in);
	a = "aabaa";
	//s.close();
	HashSet<String> hst = new HashSet<String>();
	char[] cArr = a.toCharArray();
	cArr2 = new char[2*cArr.length+1];
	int i=0;
	for (char x:cArr){
		cArr2[i] = '$';
		i++;
		cArr2[i] = x;
		i++;
	}
	cArr2[i] = '$';
	int len = cArr2.length;
	
	
	for (int k=1;k<=len-2;k++){
		if(k%2!=0){
			if (!hst.contains(cArr2[k])){
				hst.add(Character.toString(cArr2[k]));
			}
			int r = k+2;
			int l = k-2;
			while (l>=0 && r<=len-1 && cArr2[l] == cArr2[r]){
				if (!hst.contains(retStr(l,r))){
					hst.add(retStr(l,r));
				}
				r = r+2;
				l = l-2;
			}
		
		
		} else {
			int r = k+1;
			int l = k-1;
			while (l>=0 && r<=len-1 && cArr2[l] == cArr2[r]){
				if (cArr2[l]== '$'){
					r = r+1;
					l = l-1;
				} else {

					if (!hst.contains(retStr(l,r))){
						hst.add(retStr(l,r));
					}
					r = r+1;
					l = l-1;	
				}
			}
			
		}
		
	}
	
	
	System.out.println(hst.size());
}
	
	static String retStr(int l, int r){
		int s = (l-1)/2;
		int p = (r-1)/2;
		p = p+1;
		String h = a.substring(s, p);
		return h;
	}
	
	static boolean isPal(String wordOrPhrase){
        String x = wordOrPhrase;
    	String y = new StringBuffer(x).reverse().toString();
    	if (y.toLowerCase().equals(x.toLowerCase())){
        	return true;
    	}
    	else {
    		return false;
    	}
    }
}