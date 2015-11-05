package TripAdvisor;


/**
 * Created by hellsapphire on 10/31/2015.
 * <p/>
 * ? 1 char atleast
 * + 0/1 char will be implemented similar to *
 */


public class WildcardMatch {
    public static void main(String[] args) {
        String s = "rivi";
        String pat = "rivi+";
        System.out.println(isMatch(s, pat));
    }

    public static boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        if (p.isEmpty()) {
            return s.isEmpty();
        }


        if (p.charAt(0) == '*') {
            int nonStar = 0;
            while (nonStar < p.length() && p.charAt(nonStar) == '*') {
                nonStar++;
            }

            int i = 0;
            while (i <= s.length()) {
                if (isMatch(s.substring(i), p.substring(nonStar)))
                    return true;
                i++;
            }
        } else if (p.charAt(0) == '+') {
            int i = 0;
            while (i < 2) {
                if (isMatch(s.substring(i), p.substring(1)))
                    return true;

                i++;
            }
        } else if (!s.isEmpty() && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '?')) {
            return isMatch(s.substring(1), p.substring(1));
        }
        return false;
    }
}