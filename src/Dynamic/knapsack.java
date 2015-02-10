package Dynamic;

/* 0-1 knapsack - dynamic approach
			|0 									if i=0 || j=0;
p[i,j]  =	|p[i-1,j] 							if w[i] > j;
			|max{p[i-1,j], p[i]+p[i-1,j-w[i]]}	if w[i]<=j; 
*/
import java.util.*;
public class knapsack {

	
	public static void main(String[] args) {
		int[] val = {10,22,12,24,36};
		int[] wt = {2,7,8,4,12};
		ArrayList<Integer> lst = new ArrayList<Integer>();
		int kcap = 20;
		val = skipByOne(val);
		wt = skipByOne(wt);
		System.out.println("maximize the value in given kcap constraint");
		int[][] P = new int[val.length][kcap+1];
		int[][] D = new int[val.length][kcap+1];
		for (int i=0; i<val.length; i++){
			for (int j=0; j<=kcap; j++){
				if (i==0 || j==0){
					P[i][j] = 0;
					D[i][j] = 0;
				}
				else if(wt[i]>j){
					P[i][j] = P[i-1][j];
					D[i][j] = 1;
				}
				else{
					P[i][j]= maxOf(P[i-1][j], val[i]+P[i-1][j-wt[i]]);
					D[i][j] = 2;
				}
			}
		}
		System.out.println(P[val.length-1][kcap]);
		int l = val.length-1;
		int p = kcap;		
		while(l !=0 ){
			if (D[l][p] == 2){
				lst.add(l);
				p = p-wt[l];
				l--;
			}
			else if(D[l][p] == 1){
				l--;
			}
		}
		
		System.out.println(lst);

	}

	public static int[] skipByOne(int[] a){
		int last = a.length;
		int[] temp = new int[last+1];
		temp[0]=0;
		int i=1;
		for(int x:a){
			temp[i] = x;
			i++;
		}
		return temp;
	}
	public static int maxOf(int a, int b){
		if (a>=b){
			return a;
		}
		else{
			return b;
		}
	}
}
