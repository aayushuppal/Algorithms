package uncategorised;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class hkrlexo {

    static int ctr;

    public static void main(String[] args) throws FileNotFoundException {
	// Scanner in = new Scanner(new File("input.txt"));
	Scanner in = new Scanner(System.in);
	int TCases = in.nextInt();

	for (int i = 0; i < TCases; i++) {
	    String u = in.next();
	    System.out.println(LexographOut(u));
	}
	in.close();
	// System.out.println(LexographOut("wxjrhe"));
    }

    public static String LexographOut(String a) {

	String out = "";
	char[] aCArr = a.toCharArray();
	int aLen = aCArr.length;
	int swap2 = 0;
	for (int i = aLen - 2; i >= 0; i--) {
	    int index = i;
	    char aVal = aCArr[index];

	    for (int j = index + 1; j <= aLen - 1; j++) {
		if (aVal < aCArr[j]) {
		    int swap1 = i;
		    ctr = i;
		    int local = i;
		    char base = 'a';
		    int cnt = 1;
		    for (int m = local + 1; m < aLen; m++) {
			if (aCArr[m] > aCArr[swap1] && aCArr[m] < base
				|| cnt == 1) {
			    base = aCArr[m];
			    swap2 = m;
			    cnt++;
			}
		    }

		    char temp = aCArr[swap1];
		    aCArr[swap1] = aCArr[swap2];
		    aCArr[swap2] = temp;

		    for (char k : aCArr) {
			out = out + k;
		    }
		    out = SubstringSort(out, ctr);
		    return out;
		}

	    }
	}
	return "no answer";
    }

    public static String SubstringSort(String a, int ctr) {

	String sub1 = a.substring(ctr + 1, a.length());
	String sub2 = a.substring(0, ctr + 1);
	char[] sub1Arr = sub1.toCharArray();
	String out = "";
	Arrays.sort(sub1Arr);

	for (char k : sub1Arr) {
	    out = out + k;
	}
	out = sub2 + out;

	return out;
    }

}