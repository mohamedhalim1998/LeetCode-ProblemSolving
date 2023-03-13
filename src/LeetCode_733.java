import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;

public class LeetCode_733 {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        LinkedList<Pair> queue = new LinkedList<>();
        queue.add(new Pair(sc, sr));
        HashSet<Pair> visited = new HashSet<>();
        while (!queue.isEmpty()) {
            Pair curr = queue.poll();
            visited.add(curr);
            Pair[] pairs = {curr.left(), curr.right(image[0].length),curr.up(), curr.down(image.length)};
            for(Pair pair : pairs) {
                if(pair != null && !visited.contains(pair) && curr.sameColor(image, pair)) {
                    queue.add(pair);
                }
            }
            image[curr.r][curr.c] = color;
        }
        return image;

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
    public void test_1() {
        int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
        int[][] res = {{2,2,2},{2,2,0},{2,0,1}};
        Assertions.assertTrue(Arrays.deepEquals(res, floodFill(image, 1,1,2)));
    }
}
