import java.util.ArrayList;

public class LeetCode_208 {
    class Trie {
        Node node = new Node();

        public Trie() {

        }

        public void insert(String word) {
            Node curr = node;
            for (int i = 0; i < word.length(); i++) {
                if (curr.children[word.charAt(i) - 'a'] == null)
                    curr.children[word.charAt(i) - 'a'] = new Node();
                curr = curr.children[word.charAt(i) - 'a'];
                if (i == word.length() - 1)
                    curr.isWord = true;
            }

        }

        public boolean search(String word) {
            Node curr = node;
            for (int i = 0; i < word.length(); i++) {
                if (curr.children[word.charAt(i) - 'a'] == null)
                    return false;
                curr = curr.children[word.charAt(i) - 'a'];
                if (i == word.length() - 1)
                    return curr.isWord;
            }
            return false;
        }

        public boolean startsWith(String word) {
            Node curr = node;
            for (int i = 0; i < word.length(); i++) {
                if (curr.children[word.charAt(i) - 'a'] == null)
                    return false;
                curr = curr.children[word.charAt(i) - 'a'];
            }
            return true;
        }

        class Node {
            Node[] children = new Node[26];
            boolean isWord;
        }
    }

}
