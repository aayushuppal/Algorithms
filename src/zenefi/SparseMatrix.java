package zenefi;

/**
 * Created by hellsapphire on 10/5/2015.
 */
public class SparseMatrix {
    private final int N;
    private SparseVector[] rows;

    public SparseMatrix(int N) {
        this.N = N;
        this.rows = new SparseVector[N];
        for (int i = 0; i < N; i++) {
            rows[i] = new SparseVector(N);
        }
    }


    public void put(int i, int j, double value) {
        if (i < 0 || i >= N || j < 0 || j >= N) {
            throw new RuntimeException("Illegal index range");
        }
        rows[i].put(j, value);
    }

    public double get(int i, int j) {
        if (i < 0 || i >= N || j < 0 || j >= N) {
            throw new RuntimeException("Illegal index range");
        }
        return rows[i].get(j);
    }

    public SparseVector times(SparseVector b) {
        SparseMatrix a = this;
        if (a.N != b.size()) {
            throw new RuntimeException("illegal dimensions for multiplication");
        }
        SparseVector c = new SparseVector(N);

        for (int i = 0; i < N; i++) {
            c.put(i, a.rows[i].dot(b));
        }

        return c;
    }

    public SparseMatrix plus(SparseMatrix b) {
        SparseMatrix a = this;
        if (a.N != b.N) {
            throw new RuntimeException("illegal dimensions for addition");
        }
        SparseMatrix c = new SparseMatrix(N);

        for (int i = 0; i < N; i++) {
            c.rows[i] = a.rows[i].plus(b.rows[i]);
        }
        return c;
    }
}
