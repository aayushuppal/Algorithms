package Sorting;

public class QuickSortDemo {
    static int[] inp = { 12, 1, 2, 3, 1, 9, 6 };

    public static void main(String[] args) {
	QSort(0, inp.length - 1);
	for (int x : inp) {
	    System.out.print(x + " ");
	}

    }

    public static void QSort(int low, int high) {
	int i = low;
	int j = high;
	int pivot = inp[(i + j) / 2];
	while (i <= j) {
	    while (inp[i] < pivot) {
		i++;
	    }
	    while (inp[j] > pivot) {
		j--;
	    }
	    if (i <= j) {
		int temp = inp[i];
		inp[i] = inp[j];
		inp[j] = temp;
		i++;
		j--;
	    }
	}
	if (low < j) {
	    QSort(low, j);
	}
	if (high > i) {
	    QSort(i, high);
	}
    }
}
