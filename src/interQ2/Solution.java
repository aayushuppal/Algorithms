package interQ2;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {


    static int longest_chain(String[] w) {
        PriorityQueue<String> customQ = new PriorityQueue<String>(w.length, new CustomComparator());
        Set<String> dict = new HashSet<String>();
        for (String s : w) {
            dict.add(s);
            customQ.add(s);
        }

        int lC = 1;

        while (!customQ.isEmpty()){
            String temp = customQ.poll();
            if (temp.length() <= lC){
                break;
            }

            if (temp.length() > lC){
                int a = genTree(temp, dict);
                if (a>lC){
                    lC = a;
                }
            }

        }



        return lC;
    }

    static int genTree(String top, Set<String> dict ){
        WordNode root = new WordNode(top, 1);

        int maxLevel = 1;

        Queue<WordNode> listQ = new LinkedList<WordNode>();
        listQ.add(root);

        while (!listQ.isEmpty()){

            WordNode temp = listQ.remove();

            if (temp.str.length()>1){
                for(int i=temp.str.length()-1; i>=0; i--){
                    String tempStr = remOneChar(temp.str,i);
                    if (dict.contains(tempStr)){
                        int lev = temp.level+1;
                        if (lev > maxLevel){
                            maxLevel = lev;
                        }
                        WordNode wNode = new WordNode(tempStr, lev);
                        temp.next.add(wNode);
                        listQ.add(wNode);
                    }
                }
            }


        }


        return maxLevel;
    }






    static String remOneChar(String str, int i) {
        return str.substring(0, i) + str.substring(i + 1, str.length());
    }

    static class CustomComparator implements Comparator<String> {

        public int compare(String i, String j) {
            if (i.length() > j.length()) {
                return -1;
            } else if (i.length() < j.length()) {
                return 1;
            } else {
                return 0;
            }
        }

    }

    static class WordNode {
        String str;
        ArrayList<WordNode> next;
        int level;

        WordNode(String str, int level) {
            this.str = str;
            this.next = new ArrayList<WordNode>();
            this.level = level;
        }
    }


    public static void main(String[] args) throws IOException {
        /*Scanner in = new Scanner(System.in);
        final String fileName = System.getenv("OUTPUT_PATH");
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        int res;

        int _w_size = 0;
        _w_size = Integer.parseInt(in.nextLine());
        String[] _w = new String[_w_size];
        String _w_item;
        for (int _w_i = 0; _w_i < _w_size; _w_i++) {
            try {
                _w_item = in.nextLine();
            } catch (Exception e) {
                _w_item = null;
            }
            _w[_w_i] = _w_item;
        }*/

        String[] _w = {"a", "b", "bdca", "ba", "bca", "bda"};
        int res;
        res = longest_chain(_w);
        /*bw.write(String.valueOf(res));
        bw.newLine();

        bw.close();*/
    }
}
