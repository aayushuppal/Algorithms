package zenefi;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hellsapphire on 10/5/2015.
 */

public class SparseVector {
    private final int N;
    private Map<Integer, Double> st;

    public SparseVector(int N) {
        this.N = N;
        this.st = new HashMap<>();
    }

    public void put(int index, double val) {
        if (index < 0 || index >= N) {
            throw new RuntimeException("Illegal index");
        }
        if (val == 0.0) {
            if (st.containsKey(index)) {
                st.remove(index);
            }
        } else {
            st.put(index, val);
        }
    }

    public double get(int i) {
        if (i < 0 || i >= N) {
            throw new RuntimeException("Illegal index");
        }
        if (st.containsKey(i)) {
            return st.get(i);
        } else {
            return 0.0;
        }
    }

    public double dot(SparseVector b) {
        SparseVector a = this;
        if (a.N != b.N) {
            throw new RuntimeException("vector lengths disagree");
        }

        double res = 0.0;

        for (int i : a.st.keySet()) {
            res += a.get(i) * b.get(i);
        }

        return res;
    }

    public SparseVector plus(SparseVector b) {
        SparseVector a = this;

        if (a.N != b.N) {
            throw new RuntimeException("vector lengths disagree");
        }

        SparseVector c = new SparseVector(N);

        for (int i : a.st.keySet()) {
            c.put(i, a.get(i));
        }

        for (int i : b.st.keySet()) {
            c.put(i, c.get(i) + b.get(i));
        }

        return c;
    }

    public int size(){
        return N;
    }
    public static void main(String[] args) {
        SparseVector a = new SparseVector(10);
        SparseVector b = new SparseVector(10);
        a.put(3, 0.50);
        a.put(9, 0.75);
        a.put(6, 0.11);
        a.put(6, 0.00);
        b.put(3, 0.60);
        b.put(4, 0.90);
        System.out.println("a dot b = " + a.dot(b));
        System.out.println("a + b   = " + a.plus(b));
    }

}
