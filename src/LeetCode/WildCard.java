package LeetCode;


/**
 * Created by hellsapphire on 10/23/2015.
 * Wildcard Matching
 * Implement wildcard pattern matching with support for '?' and '*'.
 * <p/>
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * <p/>
 * The matching should cover the entire input string (not partial).
 */
public class WildCard {

    public static void main(String[] args) {
        System.out.println(isMatch("acd", "a**d"));

    }

    public static boolean isMatch(String s, String p) {
        if (s == null || p == null)
            return false;
        if (p.length() == 0)
            return s.length() == 0;

        if (p.charAt(0) == '*') {
            int nonStar = 0;
            while (nonStar < p.length() && p.charAt(nonStar) == '*')
                nonStar++;

            int i = 0;
            while (i < s.length()) {
                if (isMatch(s.substring(i), p.substring(nonStar))) {
                    return true;
                }
                i++;
            }
        } else if (s.length() > 0 &&
                (p.charAt(0) == s.charAt(0) ||
                        p.charAt(0) == '?')) {
            return isMatch(s.substring(1), p.substring(1));
        }

        return false;
    }
}
