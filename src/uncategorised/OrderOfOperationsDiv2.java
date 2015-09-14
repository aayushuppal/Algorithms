package uncategorised;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderOfOperationsDiv2 {

    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	int limit = in.nextInt();
	List<String> a = new ArrayList<String>();
	int i = 0;
	while (i < limit) {
	    a.add(in.nextLine());
	    i++;
	}
	in.close();
	String[] s = (String[]) a.toArray();

	int res = minTime(s);
	System.out.println(res);
    }

    public static int minTime(String[] s) {
	int n = s[0].length() - 1;
	char[] marker = new char[s[0].length()];
	for (int o = 0; o < s[0].length(); o++) {
	    marker[o] = '0';
	}

	for (int y = 0; y < s.length; y++) {
	    marker = ORoper(marker, s[y].toCharArray());
	}

	return 0;
    }

    public static char[] ORoper(char[] a, char[] b) {
	char[] res = new char[a.length];
	for (int i = 0; i < a.length; i++) {
	    if (a[i] == '1' || b[i] == '1') {
		res[i] = '1';
	    } else {
		res[i] = '0';
	    }
	}
	return res;
    }
}
