import org.junit.Test;

import java.util.HashSet;
import java.util.Objects;

public class LeetCode_52 {
    public int totalNQueens(int n) {
        var ans = new HashSet<HashSet<Pair>>();
        totalNQueens(n, n, new HashSet<>(), ans, 0);
        return ans.size();
    }

    private void totalNQueens(int n, int remain, HashSet<Pair> list, HashSet<HashSet<Pair>> ans, int start) {
        if (remain == 0) {
            ans.add(list);
//            System.out.println("VALID: " + list);
            return;
        }
        for (int i = start; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isValid(Pair.of(i, j), list)) {
                    var newList = new HashSet<>(list);
                    newList.add(Pair.of(i, j));
//                    used[i][j] = true;
                    totalNQueens(n, remain - 1, newList, ans, i + 1);
                }
            }
        }
    }

    private boolean isValid(Pair pair, HashSet<Pair> list) {
        for (var p : list) {
            if (p.x == pair.x || p.y == pair.y || sameDiagonal(pair, p)) {
                return false;
            }
        }
        return true;
    }

    private boolean sameDiagonal(Pair pair, Pair p) {
        return Math.abs(pair.x - p.x) == Math.abs(pair.y - p.y);
    }

    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public static Pair of(int x, int y) {
            return new Pair(x, y);
        }

        @Override
        public String toString() {
            return x + "," + y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return x == pair.x && y == pair.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    @Test
    public void test() {
        System.out.println(totalNQueens(4));
    }
}
