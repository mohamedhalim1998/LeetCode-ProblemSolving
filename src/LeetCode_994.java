import java.util.*;

public class LeetCode_994 {
    public int orangesRotting(int[][] grid) {
        Queue<Pair> queue = new LinkedList<>();
        int[][] rotten = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            Arrays.fill(rotten[i], -1);
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new Pair(j, i));
                    rotten[i][j] = 0;
                }
            }
        }
        HashSet<Pair> visited = new HashSet<>();
        int max = 0;
        while (!queue.isEmpty()) {
            Pair curr = queue.poll();
            if (visited.contains(curr))
                continue;
            visited.add(curr);
            Pair[] neighbours = {curr.up(), curr.left(), curr.right(grid[0].length), curr.down(grid.length)};
            for (Pair p : neighbours) {
                if (p != null && grid[p.r][p.c] == 1 && rotten[p.r][p.c] == -1) {
                    rotten[p.r][p.c] = rotten[curr.r][curr.c] + 1;
                    max = Math.max(max, rotten[p.r][p.c]);
                    queue.add(p);
                }
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1 && rotten[i][j] == -1) {
                    return -1;
                }
            }
        }
        return max;
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
