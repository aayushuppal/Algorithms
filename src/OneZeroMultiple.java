

public class OneZeroMultiple {
	public static void main(String[] args) {

		checkSZone(89980);	
		
		
	}
	
	
	public static void checkSZone(int asd){
		if (asd == 0){
			System.out.println(0);
		}
		
		else if(isAllNine(asd)){
			String h ="";
			int len = String.valueOf(asd).length();
			for (int u=0; u<len; u++){
				h = h+"111111111";
			}
			System.out.println(h);
		}
		else {

			long sdf = asd;
			int i = asd;
			
			String temp = Integer.toBinaryString(i);
			Double tempnum = Double.parseDouble(temp);
			
			while(tempnum%sdf != 0){
				i++;
				//System.out.println(i);
				temp = Integer.toBinaryString(i);
				tempnum = Double.parseDouble(temp);
			}
			System.out.println(Long.parseLong(Integer.toBinaryString(i)));	
		}
	}
	
	
	public static boolean isAllNine(int a){
    	boolean b = false;

    	char[] cArr =  String.valueOf(a).toCharArray(); 
    	char t = '9';
    	for (char x:cArr){
    		if(x != t){
    			b = false;
    			break;
    		}
    		else{
    			b = true;
    		}
    		
    	}
    	return b;
    }
    
}

