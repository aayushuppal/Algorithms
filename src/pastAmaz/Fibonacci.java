package pastAmaz;


public class Fibonacci {
    static int limit = 10;
    static int[] fib = new int[limit + 1];

    public static void main(String[] args) {
	// IterativegenFib(limit);

	RecursivegenFib(limit);
	int[] h = fib;
	System.out.println(h);
	System.out.println("-----------");
	RecvFib(limit);
	System.out.println("-----------");

    }

    public static void IterativegenFib(int limit) {
	int c = 1, p = 0;
	for (int i = 0; i < limit; i++) {
	    if (i < 2) {
		System.out.println(i);
	    } else {
		int sum = c + p;
		p = c;
		c = sum;
		System.out.println(sum);
	    }
	}
    }

    public static int RecursivegenFib(int limit) {
	if (limit < 2) {
	    fib[limit] = limit;
	    return limit;
	}
	int a = RecursivegenFib(limit - 1) + RecursivegenFib(limit - 2);
	fib[limit - 1] = a;
	return a;
    }

    public static int RecvFib(int nterm) {
	if (nterm < 2) {
	    fib[nterm] = nterm;
	    return nterm;
	}
	fib[nterm] = RecvFib(nterm - 1) + RecvFib(nterm - 2);
	return fib[nterm];
    }
}
