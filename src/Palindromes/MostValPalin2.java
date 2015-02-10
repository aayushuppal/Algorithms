package Palindromes;


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MostValPalin2 {
  /*
 * Complete the function below.
 */

    static HashSet<String> palindrome(String str) {
    HashSet<String> hst= new HashSet<String>();
    int len = str.length();
    
    for (int i=1; i<=len; i++){
    	for (int j=0; j<=len-1-i+1; j++){
    		String a = str.substring(j, j+i);
    		if (!hst.contains(a) && checkpal(a)){
    			hst.add(a);
    		}
    	}
    }
    return hst;
}
    static boolean checkpal(String x){
    	String y = new StringBuffer(x).reverse().toString();
    	if (y.equals(x)){
        	return true;
    	}
    	else {
    		return false;
    	}
    }
    
    static boolean hasDiffChar(String a){
    	boolean b = false;
    	char[] cArr = a.toCharArray();
    	char t = cArr[0];
    	for (char x:cArr){
    		if(x != t){
    			b = true;
    			break;
    		}
    		else{
    			b = false;
    		}
    		
    	}
    	return b;
    }
    
    static int stval(String z){
    	int c=0;
    	char[] cArr = z.toCharArray();
    	for (char x:cArr){
    		int t = (int) x - 64;
    		c = c+t;
    	}
    	return c;
    }
    
    public static void main(String[] args) throws IOException{
    	HashSet<String> tst= new HashSet<String>();
    	ArrayList<Integer> al = new ArrayList<Integer>(); 
    	int res;
        tst = palindrome("XABAXAYEDADZAZ");
        System.out.println(tst);

        
        for (String z:tst){
        	if(hasDiffChar(z)){
        		al.add(stval(z));
        	}
        }
        Collections.sort(al);
        System.out.println(al.get(al.size()-1));
        
    }
}
