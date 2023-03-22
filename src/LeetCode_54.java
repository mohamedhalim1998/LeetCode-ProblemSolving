import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class LeetCode_54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        HashSet<Pair> set = new HashSet<>();
        int n = matrix.length;
        int m = matrix[0].length;
        int rf = 0;
        int cf = 0;
        int rr = n - 1;
        int cr = m - 1;
        /*
        1 - > row
        2 -> row reverse
        3 -> col
        4 -> col reverse
         */


        int travel = 1;
        List<Integer> list = new ArrayList<>();
        int count = 0;
        while (count < n * m) {
            switch (travel) {
                case 1:
                    for (int i = 0; i < m; i++) {
                        Pair pair = new Pair(rf, i);
                        if (!set.contains(pair)) {
                            set.add(pair);
                            count++;
                            list.add(matrix[rf][i]);
                        }
                    }
                    rf++;
                    travel = 3;
                    break;
                case 2:
                    for (int i = m-1; i >= 0; i--) {
                        Pair pair = new Pair(rr, i);
                        if (!set.contains(pair)) {
                            set.add(pair);
                            count++;
                            list.add(matrix[rr][i]);
                        }
                    }
                    rr--;
                    travel = 4;
                    break;
                case 3:
                    for (int i = 0; i < n; i++) {
                        Pair pair = new Pair(i, cr);
                        if (!set.contains(pair)) {
                            set.add(pair);
                            count++;
                            list.add(matrix[i][cr]);
                        }
                    }
                    cr--;
                    travel = 2;
                    break;
                case 4:
                    for (int i = n - 1; i >= 0; i--) {
                        Pair pair = new Pair(i, cf);
                        if (!set.contains(pair)) {
                            set.add(pair);
                            count++;
                            list.add(matrix[i][cf]);
                        }
                    }
                    cf++;
                    travel = 1;
                    break;
            }

        }
        return list;

    }

    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
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

        @Override
        public String toString() {
            return "Pair{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    @Test
    public void test_1() {
        int[][] mat = {{1,2,3},{4,5,6},{7,8,9}};
        List<Integer> list = List.of(1,2,3,6,9,8,7,4,5);
        Assertions.assertEquals(list, spiralOrder(mat));
    }
    @Test
    public void test_2() {
        int[][] mat = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        List<Integer> list = List.of(1,2,3,4,8,12,11,10,9,5,6,7);
        Assertions.assertEquals(list, spiralOrder(mat));
    }
    
}
