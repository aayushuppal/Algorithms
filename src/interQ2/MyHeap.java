package interQ2;

/**
 * Created by hellsapphire on 9/27/2015.
 */
public class MyHeap {
    Comparable[] data;
    private int nextTolast;
    private int minMaxer;
    // 1: maxHeap, -1: minHeap

    MyHeap(int size, int minMaxer) {
        this.minMaxer = minMaxer;
        data = new Comparable[size];
        nextTolast = 1;
    }

    public void add(Comparable val) {
        if (nextTolast >= data.length) {
            System.out.println("unable to add");
            return;
        }
        data[nextTolast] = val;
        swim(nextTolast);
        nextTolast++;
    }

    private void swim(int k) {
        while (k / 2 >= 1 && compare(k, k / 2)) {
            Comparable temp = data[k];
            data[k] = data[k / 2];
            data[k / 2] = temp;
            k = k / 2;
        }
    }

    public Comparable remove() {
        int k = 1;
        /*if (k < 1 || k >= data.length) {
            return null;
        }*/
        Comparable res = data[k];
        data[k] = data[nextTolast - 1];
        data[nextTolast - 1] = null;
        nextTolast--;
        sink(k);
        return res;
    }

    private void sink(int k) {
        while (2 * k <= nextTolast-1) {
            int j = 2 * k;
            if (j < nextTolast-1 && compare(j + 1, j)) {
                j++;
            }
            if (!compare(j, k)) {
                break;
            }
            Comparable temp = data[j];
            data[j] = data[k];
            data[k] = temp;
            k = j;
        }
    }

    private boolean compare(int i, int j) {
        switch(minMaxer){
            case 1:
                // max comparison, returns true if data[i] > data[j]; MAX HEAP
                return data[i].compareTo(data[j]) > 0;
            case -1:
                // max comparison, returns true if data[i] > data[j]; MAX HEAP
                return data[i].compareTo(data[j]) < 0;
            default:
                return false;
        }
    }

    public int size(){
        return nextTolast-1;
    }

}

