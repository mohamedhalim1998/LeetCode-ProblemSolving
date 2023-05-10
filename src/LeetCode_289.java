import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class LeetCode_289 {
    static int n, m;

    public void gameOfLife(int[][] board) {
        n = board.length;
        m = board[0].length;
        HashSet<Pair> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Pair pair = new Pair(j, i);
                if(pair.willChange(board)) {
                    set.add(pair);
                }
            }
        }
        for(Pair p : set) {
            board[p.r][p.c] = 1 -board[p.r][p.c];
        }

    }

    static class Pair {
        int c, r;

        public Pair(int c, int r) {
            this.c = c;
            this.r = r;
        }

        public boolean willChange(int[][] board) {
            int count = 0;
            int[] arr = {-1, 0, 1};
            for (int i : arr) {
                for (int j : arr) {
                    if (i == 0 && j == 0)
                        continue;
                    int c = this.c + i;
                    int r = this.r + j;
                    if (c >= m || r >= n || c < 0 || r < 0)
                        continue;
                    if (board[r][c] == 1)
                        count++;
                }
            }
            if(board[r][c] == 1) {
                return count < 2 || count > 3;
            } else {
                return count == 3;
            }
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
}
