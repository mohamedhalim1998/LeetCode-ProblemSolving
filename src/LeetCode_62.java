import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LeetCode_62 {
    int[][] mem = new int[101][101];

    public int uniquePaths(int m, int n) {
        return uniquePaths(m, n, 0, 0);
    }

    private int uniquePaths(int m, int n, int i, int j) {
        if (mem[i][j] != 0)
            return mem[i][j];
        if (i == m - 1 && j == n - 1)
            return 1;
        int res = 0;
        if (i < m - 1)
            res += uniquePaths(m, n, i + 1, j);
        if (j < n - 1)
            res += uniquePaths(m, n, i, j + 1);
        mem[i][j] = res;
        return res;
    }

    @Test
    public void test_1() {
        Assertions.assertEquals(28, uniquePaths(3,7));
    }
}
