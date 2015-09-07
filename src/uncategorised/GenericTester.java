package uncategorised;

public class GenericTester {
    public static void main(String[] args) {
	Integer[] arr = { 1, 6, 2, 7, 9, 2, 8 };
	GenericQSort<Integer[]> genObj = new GenericQSort<Integer[]>(arr);
	genObj.fxn(12);
    }
}

class GenericQSort<E> {
    E e;

    public GenericQSort(E e) {
	this.e = e;
    }

    public void QuickSort(E e) {
	int wall = 0;

    }
}
