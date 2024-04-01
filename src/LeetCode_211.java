import org.junit.Test;

import java.util.HashMap;

public class LeetCode_211 {
    class WordDictionary {
        private TrieNode root;


        public WordDictionary() {
            root = new TrieNode();
        }

        public void addWord(String word) {
            TrieNode curr = root;
            for (var c : word.toCharArray()) {
                curr = curr.map.computeIfAbsent(c, v -> new TrieNode());
            }
            curr.isWord = true;
        }

        public boolean search(String word) {
            return search(word, root, 0);
        }

        private boolean search(String word, TrieNode root, int index) {
            if (index == word.length()) {
                return root.isWord;
            }
            var c = word.charAt(index);
            if (c == '.') {
                return root.map.values().stream().anyMatch(node -> search(word, node, index + 1));
            } else if (!root.map.containsKey(c)) {
                return false;
            } else {
                return search(word, root.map.get(c), index + 1);
            }
        }

        static class TrieNode {
            HashMap<Character, TrieNode> map = new HashMap<Character, TrieNode>();
            boolean isWord;
        }
    }

    @Test
    public void test1() {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        wordDictionary.search("pad"); // return False
        wordDictionary.search("bad"); // return True
        wordDictionary.search(".ad"); // return True
        wordDictionary.search("b.."); // return True
    }


/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
}
