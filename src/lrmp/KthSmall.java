package lrmp;

/**
 * Created by hellsapphire on 10/9/2015.
 */
public class KthSmall {

    public static void main(String[] args) {
        int[] inp = {1, 2, 5, 2, 7, 8, 2, 3, 9, 0};
        qSort(inp,0,inp.length-1);
        System.out.println(getKthSmall(inp, 0, inp.length - 1, 7));
    }

    public static int getKthSmall(int[] A, int start, int end, int k){
        int pivot = A[end];
        int left = start;
        int right = end;

        while(true) {
            while (left < right && A[left] < pivot){
                left++;
            }
            while(left < right && A[right]>= pivot){
                right--;
            }
            if (left == right){
                break;
            }
            swap(A,left,right);
        }
        swap(A,left,end);
        if (k == left+1){
            return pivot;
        } else if (k > left+1){
            return getKthSmall(A, left + 1, end, k);
        } else {
            return getKthSmall(A,start,left-1,k);
        }
    }

    public static void qSort(int[] A, int start, int end){
        if (start >= end){
            return;
        }

        int pivot = A[end];
        int left = start;
        int right = end;

        while(true){
            while(left<right && A[left]<pivot){
                left++;
            }
            while(left <right && A[right]>=pivot){
                right--;
            }
            if (left == right){
                break;
            }
            swap(A,left,right);
        }
        swap(A,left,end);

        qSort(A,start,left-1);
        qSort(A,left+1,end);
    }

    private static void swap(int[] A, int l, int r) {
        int temp = A[l];
        A[l] = A[r];
        A[r] = temp;
    }

}
