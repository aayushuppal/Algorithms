package tree;

import java.util.*;

/**
 * Created by hellsapphire on 10/28/2015.
 */
class TrieNode {
    // Initialize your data structure here.
    char val;
    HashMap<Character, TrieNode> adjMap;
    String word;
    HashSet<String> words;
    // instead of storing words/word could keep isLeaf boolean flag

    public TrieNode(char a) {
        val = a;
        adjMap = new HashMap<>();
        word = null;
        words = new HashSet<>();
    }

    public TrieNode() {
        adjMap = new HashMap<>();
        words = new HashSet<>();
    }

}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        char[] cArr = word.toCharArray();
        TrieNode curr = root;
        curr.words.add(word);
        int i = 0;

        while (i < cArr.length && curr.adjMap.containsKey(cArr[i])) {
            curr = curr.adjMap.get(cArr[i++]);
            curr.words.add(word);
        }

        int j;
        for (j = i; j < cArr.length; j++) {
            TrieNode temp = new TrieNode(cArr[j]);
            curr.adjMap.put(cArr[j], temp);
            curr = temp;
            curr.words.add(word);
        }

        if (j == cArr.length) {
            curr.word = word;
            return;
        }

    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode curr = root;
        int i = 0;

        while (i < word.length() && curr.adjMap.containsKey(word.charAt(i))) {
            curr = curr.adjMap.get(word.charAt(i++));
        }

        if (i == word.length() && curr.word != null && curr.word.equals(word)) {
            return true;
        }

        return false;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        int i = 0;

        while (i < prefix.length() && curr.adjMap.containsKey(prefix.charAt(i))) {
            curr = curr.adjMap.get(prefix.charAt(i++));
        }

        if (i == prefix.length()) {
            for (TrieNode x : curr.adjMap.values()) {
                if (x.words.size() > 0) {
                    return true;
                }
            }
        }


        return false;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("ab");

        System.out.println(trie.search("a"));
        System.out.println(trie.startsWith("a"));
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");