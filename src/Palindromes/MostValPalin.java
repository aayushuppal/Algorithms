package Palindromes;

//Problem        : Most Valuable Palindrome
//Language       : Java
//Compiled Using : javac
//Version        : Java 1.7.0_65
//Input for your program will be provided from STDIN
//Print out all output from your program to STDOUT

import java.io.*;
import java.util.*;
import java.util.Scanner;
//Your submission should *ONLY* use the following class name
public class MostValPalin
{
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
    
    public static void main(String[] args)
    {
        HashSet<String> tst= new HashSet<String>();
    	ArrayList<Integer> al = new ArrayList<Integer>(); 
        
       Scanner stdin = new Scanner(System.in);
       while(stdin.hasNextLine()) 
       {
    	tst.clear();
    	al.clear();
        tst = palindrome(stdin.nextLine());
        for (String z:tst){
        	if(hasDiffChar(z)){
        		al.add(stval(z));
        	}
        }
        if(al.isEmpty()){
        	System.out.println(0);
        }else{
        	Collections.sort(al);
            System.out.println(al.get(al.size()-1));	
        }
       }
       stdin.close();
    }

}
