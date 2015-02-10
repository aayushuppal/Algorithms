package PrimeFactors;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SuperPower {

	static int superPower(int z) {
	
		if (isSuperPower(primeFactors(z),z)){
			return 1;
		} else {
			return 0;
		}
    }
	
	public static HashMap<Integer,Integer> primeFactors(int number) {
        int i;
        HashMap<Integer,Integer> pfac = new HashMap<Integer,Integer>();
        int copyOfInput = number;
        if (copyOfInput == 1){
        	pfac.put(1, 1);
        }
        for (i = 2; i <= copyOfInput; i++) {
            if (copyOfInput % i == 0) {
                if(pfac.containsKey(i)){
                	int value = pfac.get(i)+1;
                	pfac.put(i, value);
                } else {
                	pfac.put(i, 1);
                }
                copyOfInput /= i;
                i--;
            }
        }
        return pfac;
    }
    
    public static boolean isSuperPower(HashMap<Integer,Integer> hmp,int number){
    	if(hmp.keySet().size() > 1 && isEvenVal(hmp.values()) || isSameVal(hmp.values()) && !hmp.containsValue(1)){
    		return true;
    	}
    	else if(hmp.keySet().size() == 1 && !hmp.containsKey(number)){
    		return true;
    	} else {
    		return false;
    	}
    }
    
    public static boolean isSameVal(Collection<Integer> cl){
    	Object[] clAr = cl.toArray();
    	Object t = clAr[0];
    	for (Object x:clAr){
    		if (x !=t){
    			return false;
    		}
    	}
    	return true;
    }
    
    public static boolean isEvenVal(Collection<Integer> cl){
    	Object[] clAr = cl.toArray();
    	for (Object x:clAr){
    		if ((int)x%2 !=0){
    			return false;
    		}
    	}
    	return true;
    }

	
	
    public static void main(String[] args) throws IOException{
        /*
          Scanner in = new Scanner(System.in);
         
        final String fileName = System.getenv("OUTPUT_PATH");
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        int res;
        int _z;
        _z = Integer.parseInt(in.nextLine());
        
        res = superPower(_z);
        bw.write(String.valueOf(res));
        bw.newLine();
        
        bw.close();
        *//*
    	for (int i=1; i<=100; i++){

        	System.out.printf("%d : %d \n",i,superPower(i));	
        	
    	}*/
    	int i = 325;
    	System.out.printf("%d : %d \n",i,superPower(i));
    }
    
}