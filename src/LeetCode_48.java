import org.junit.jupiter.api.Test;

import java.util.Objects;

public class LeetCode_48 {
    public void rotate(int[][] matrix) {
        int m = matrix[0].length;
        for (int i = 0; i < (matrix.length + 1) / 2; i++) {
            for (int j = i; j < matrix[0].length - i - 1; j++) {
                Pair start = new Pair(i, j);
                Pair curr = start;
                int val = matrix[i][j];
                while (!curr.convert(m).equals(start)) {
                    curr = curr.convert(m);
                    int temp = val;
                    val = matrix[curr.i][curr.j];
                    matrix[curr.i][curr.j] = temp;
                }
                curr = curr.convert(m);
                int temp = val;
                matrix[curr.i][curr.j] = temp;
            }
        }
    }

    class Pair {
        int i, j;

        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return i == pair.i && j == pair.j;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, j);
        }

        public Pair convert(int m) {
            return new Pair(j, m-i - 1);
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "i=" + i +
                    ", j=" + j +
                    '}';
        }
    }

    @Test
    public void test() {
        int[][] arr = new int[][]{
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };
        rotate(arr);
    }

    @Test
    public void test2() {
        int[][] arr = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        rotate(arr);
    }
}
