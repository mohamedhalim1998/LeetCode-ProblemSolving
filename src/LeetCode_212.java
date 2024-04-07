import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetCode_212 {


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

    static int[][] moves = new int[][]{
            new int[]{0, 1},
            new int[]{0, -1},
            new int[]{1, 0},
            new int[]{-1, 0},
    };


    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (var word : words) {
            trie.insert(word);
        }
        Set<String> ans = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                Trie.Node root = trie.node;
                boolean[][] visited = new boolean[board.length][board[0].length];
                searchWord(board, i, j, visited, root, "", ans);
            }
        }
        return new ArrayList<>(ans);


    }

    private void searchWord(char[][] board, int i, int j,boolean[][] visited, Trie.Node node, String builder, Set<String> ans) {
        var c = board[i][j];
//        System.out.println("CHECKING: " + builder + c);
        if(visited[i][j]) {
//            System.out.println("VISITED before");
            return;
        }
        visited[i][j] = true;

        if (node.children[c - 'a'] == null) {
//            System.out.println("FAILED");
            return;
        }
        builder += c;
        if(node.children[c - 'a'].isWord) {
            ans.add(builder.toString());
//            System.out.println("FOUND WORD");
        }
//        System.out.println("FOUND BUT NOT A WORD");


        for (int k = 0; k < moves.length; k++) {
            int[] move = moves[k];
            if (isValidMove(moves[k], i, j, board.length, board[0].length)) {
                searchWord(board, i + move[0], j + move[1], visited, node.children[c - 'a'], builder, ans);
            }
        }
        visited[i][j] = false;
    }

    private boolean isValidMove(int[] move, int i, int j, int m, int n) {
        int newI = move[0] + i;
        int newJ = move[1] + j;
        return newI >= 0 && newI < m && newJ >= 0 && newJ < n;

    }

    @Test
    public void test() {

        char[][] myArray = {{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};
        System.out.println(findWords(myArray, new String[]{"oath","pea","eat","rain","hklf", "hf"}));
    }
}
