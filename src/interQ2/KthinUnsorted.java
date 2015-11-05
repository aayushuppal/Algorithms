package interQ2;

import java.util.Arrays;

/**
 * Created by hellsapphire on 9/27/2015.
 */
public class KthinUnsorted {

    public static void main(String[] args) {
        int[] input = {2, 7, 3, 1, 2,9, 1};
        System.out.println(getKthLargest(input, 0, input.length - 1, 3));
    }

    public static int  getKthLargest(int[] A, int start, int end, int k) {
        int left = start;
        int right = end;
        int pivot = A[end];

        while (true) {
            while (left < right && A[left] < pivot) {
                left++;
            }
            while (left < right && A[right] >= pivot) {
                right --;
            }
            if (left == right){
                break;
            }
            swap(A, left, right);
        }
        swap(A, left, end);

        if (k == left +1){
          return pivot;
        } else if (k < left+1){
            return getKthLargest(A, start, left-1, k);
        } else {
            return getKthLargest(A, left+1,end, k);
        }
    }

    public static void swap(int[] A, int left, int right){
        int temp = A[left];
        A[left] = A[right];
        A[right] = temp;
    }

    public static int[] QuickSort(int[] A, int start, int end){
        int left = start;
        int right = end;
        int pivot = A[end];

        while (true){
            while (left < right && A[left] < pivot){
                left++;
            }
            while (left < right && A[right] >= pivot){
                right --;
            }
            if (left == right){
                break;
            }
            swap(A,left,right);
        }

        swap(A, left, end);
        if (start < left-1 && start >= 0){
            QuickSort(A, start, left-1);
        }
        if (left+1 < end && end <= A.length-1){
            QuickSort(A, left+1, end);
        }
        return A;
    }
}