import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

public class LeetCode_417 {
    HashSet<Pair> canReach = new HashSet<>();
    int n, m;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        n = heights.length;
        m = heights[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Pair p = new Pair(j, i);
                if (!canReach.contains(p)) {
                    dfs(heights, p);
                }
            }
        }
        return canReach.stream().map(pair -> List.of(pair.r, pair.c)).toList();
    }

    private void dfs(int[][] heights, Pair pair) {
        HashSet<Pair> visited = new HashSet<>();
        boolean pacific = false;
        boolean atlantic = false;
        Stack<Pair> stack = new Stack<>();
        stack.add(pair);
        while (!stack.isEmpty()) {
            Pair curr = stack.pop();
            if (visited.contains(curr))
                continue;

            visited.add(curr);
            if (curr.up() == null || curr.left() == null) {
                pacific = true;
            }
            if (curr.right(m) == null || curr.down(n) == null) {
                atlantic = true;
            }
            if (pacific && atlantic) {
                canReach.add(pair);
                return;
            }
            Pair[] neighbours = {curr.up(), curr.left(), curr.right(m), curr.down(n)};
            for (Pair p : neighbours) {
                if (p != null && heights[p.r][p.c] <= heights[curr.r][curr.c]) {

                    stack.add(p);
                }
            }
        }
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

}
