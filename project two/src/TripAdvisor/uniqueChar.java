package TripAdvisor;

/**
 * Created by hellsapphire on 11/1/2015.
 */
public class uniqueChar {

    public static void main(String[] args) {
        String s = "cabcabd";
        int[] count = new int[256];

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i)] == 1) {
                System.out.println(s.charAt(i));
            }
        }

        System.out.println(getFirstUniq(s));
    }

    public static Character getFirstUniq(String s) {
        Character res = null;

        int i = 0;
        while (i < s.length()) {
            if (getCount(s, 0, s.charAt(i)) == 1) {
                res = new Character(s.charAt(i));
                break;
            }
            i++;
        }

        return res;
    }


    public static int getCount(String s, int pos, char c) {
        if (pos >= s.length()) {
            return 0;
        }

        if (s.charAt(pos) == c) {
            return 1 + getCount(s, pos + 1, c);
        } else {
            return getCount(s, pos + 1, c);
        }
    }


}
