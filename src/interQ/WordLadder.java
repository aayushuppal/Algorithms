package interQ;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import java.util.*;

/**
 * Created by hellsapphire on 9/26/2015.
 */

/*      start = "hit"
        end = "cog"
        dict = ["hot","dot","dog","lot","log"]
*/

public class WordLadder {
    static Set<String> dict = new HashSet<String>();
    static String[] dictArr = {"hot", "dot", "dog", "lot", "log"};


    public static void main(String[] args) {
        dict.addAll(Arrays.asList(dictArr));
        System.out.println(ladderLength("hit", "cog"));
    }

    public static int ladderLength(String start, String end) {
        Queue<WordNode> queue = new LinkedList<WordNode>();
        dict.add(end);
        queue.add(new WordNode(start, 1));

        while (!queue.isEmpty()) {
            WordNode top = queue.remove();

            if (top.str.equals(end)) {
                return top.level;
            }
            char[] wordArr = top.str.toCharArray();

            for (int i = 0; i < wordArr.length; i++) {
                char temp = wordArr[i];

                for (char c = 'a'; c <= 'z'; c++) {
                    if (c != temp) {
                        wordArr[i] = c;
                        String newWord = new String(wordArr);
                        if (dict.contains(newWord)) {
                            System.out.println(newWord + " " + (top.level + 1));
                            queue.add(new WordNode(newWord, top.level + 1));
                            dict.remove(newWord);
                        }
                        wordArr[i] = temp;
                    }
                }
            }


        }

        return 0;
    }

    static class WordNode {
        String str;
        int level;

        WordNode(String in, int lev) {
            this.str = in;
            this.level = lev;
        }
    }

}
