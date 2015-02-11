package pastAmaz;

import java.util.regex.*;


public class versionNumCompare {

	public static void main(String[] args) {
		String x = "12.21.0001"; //"12.21.3456"; "12.21.3456";
		String y = "12.21.001"; //"12.21.3457"; "12.21";
		
		
		String[] arr1 = x.split("\\.");
		String[] arr2 = y.split("\\.");
		int out = 0;
		int len = Math.min(arr1.length, arr2.length);
		
		for (int i = 0; i< len; i++){
			int a  = Integer.parseInt(arr1[i]);
			int b  = Integer.parseInt(arr2[i]);
			if (a!=b){
				out = a>b ? 1:2;
			}
		}
		
		if (out == 0 && arr1.length == arr2.length){
			if (arr1[len-1].length() != arr2[len-1].length() ){
				out = arr1[len-1].length() < arr2[len-1].length() ? 1:2;
				System.out.printf("%d bigger\n",out);
			} else {
				System.out.println("equal numbers");	
			}
		} else if(out == 1){
			System.out.println("1 bigger");
		} else if(out == 2){
			System.out.println("2 bigger");
		} else {
			out = arr1.length > arr2.length ? 1:2;
			System.out.printf("%d bigger\n",out);
		}
		
	}

}
