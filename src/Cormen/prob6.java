package Cormen;
/* Given an image represented by an NxN matrix, where each pixel in the image is 4
bytes, write a method to rotate the image by 90 degrees. Can you do this in place? */
import java.util.Random;

public class prob6 {

public static void main(String[] args) {
prob6 pob = new prob6();
int n = 5;	
Random ran = new Random();
int[] [] mat = new int[n][n];


for (int i=0; i<n; i++){
for (int j=0; j<n; j++){
mat[i][j] = ran.nextInt((10-1)+1)+1;
	}	
}

int count = 0;


for (int i=n; i>0; i=i-2){
int first = 0 + count;
int last = n-1 - count;
int ct=0;
for(int k=first; k<last; k++){
	
	int temp = mat[first][k];
	mat[first][k] = mat[last-ct][first];
	mat[last-ct][first] = mat[last][last-ct];
	mat[last][last-ct] = mat[k][last];
	mat[k][last] = temp;
	ct++;
}

count++;
}

}

}
