import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Objects;

public class LeetCode_79 {
    public boolean exist(char[][] board, String word) {
        HashSet<Character> set = new HashSet<>();
        for (char[] chars : board) {
            for (int j = 0; j < board[0].length; j++) {
                set.add(chars[j]);
            }
        }
        for (int i = 0; i < word.length(); i++) {
            if(!set.contains(word.charAt(i)))
                return false;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0))
                    if (dfs(new Pair(j, i), word, board)) {
                        return true;
                    }
            }
        }
        return false;

    }

    private boolean dfs(Pair start, String word, char[][] board) {
        HashSet<Pair> visited = new HashSet<>();
        int index = 0;
        return dfs(start, word, board, index, visited);
    }

    private boolean dfs(Pair curr, String word, char[][] board, int index, HashSet<Pair> visited) {
        if (index == word.length() - 1)
            return true;
        if (visited.contains(curr))
            return false;
        visited.add(curr);
        index++;
        Pair[] pairs = {curr.left(), curr.right(board[0].length), curr.up(), curr.down(board.length)};
        boolean res = false;
        for (Pair pair : pairs) {
            if (pair != null && !visited.contains(pair) && board[pair.r][pair.c] == word.charAt(index)) {
                res = res || dfs(pair, word, board, index, visited);
            }
        }
        visited.remove(curr);
        return res;
    }

    static class Pair {
        int c, r;

        public Pair(int c, int r) {
            this.c = c;
            this.r = r;
        }

        public Pair right(int m) {
            if (c + 1 < m)
                return new Pair(c + 1, r);
            return null;
        }

        public Pair up() {
            if (r - 1 >= 0)
                return new Pair(c, r - 1);
            return null;
        }

        public Pair down(int n) {
            if (r + 1 < n)
                return new Pair(c, r + 1);
            return null;
        }

        public Pair left() {
            if (c - 1 >= 0)
                return new Pair(c - 1, r);
            return null;
        }

        public boolean sameColor(int[][] image, Pair other) {
            return image[r][c] == image[other.r][other.c];
        }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return c == pair.c && r == pair.r;
        }

        @Override
        public int hashCode() {
            return Objects.hash(c, r);
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "c=" + c +
                    ", r=" + r +
                    '}';
        }
    }

    @Test
    public void test1() {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        Assertions.assertTrue(exist(board, "ABCCED"));

    }

    @Test
    public void test2() {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        Assertions.assertTrue(exist(board, "SEE"));

    }

    @Test
    public void test4() {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        Assertions.assertFalse(exist(board, "ABCB"));

    }

    @Test
    public void test3() {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'E', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        Assertions.assertTrue(exist(board, "ABCESEEEFS"));

    }
}
