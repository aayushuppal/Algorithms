package leetCode;

import java.util.*;

/**
 * Created by hellsapphire on 10/30/2015.
 * <p/>
 * Word pattern
 * <p/>
 * Given a pattern and a string str, find if str follows the same pattern.
 * <p/>
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.
 * <p/>
 * Examples:
 * pattern = "abba", str = "dog cat cat dog" should return true.
 * pattern = "abba", str = "dog cat cat fish" should return false.
 * pattern = "aaaa", str = "dog cat cat dog" should return false.
 * pattern = "abba", str = "dog dog dog dog" should return false.
 * Notes:
 * You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.
 */
public class wordPattern {

    public static void main(String[] args) {
        wordPatt("ab", "dog dog");
    }

    public static boolean wordPatt(String pattern, String str) {
        HashMap<Character, String> map = new HashMap<>();
        HashMap<String, Character> map2 = new HashMap<>();
        String[] arr = str.split(" ");

        if (arr.length != pattern.length()) {
            return false;
        }

        for (int i = 0; i < pattern.length(); i++) {

            char c = pattern.charAt(i);

            if (!map.containsKey(c) && !map2.containsKey(arr[i])) {
                map.put(c, arr[i]);
                map2.put(arr[i], c);
            } else if (map.containsKey(c) && !map.get(c).equals(arr[i])) {
                return false;
            } else if (map2.containsKey(arr[i]) && map2.get(arr[i]) != c) {
                return false;
            } else {
                continue;
            }


        }

        return true;
    }
}
