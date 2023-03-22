import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LeetCode_1706 {

    public int[] findBall(int[][] grid) {
        int[] ans = new int[grid[0].length];
        for (int i = 0; i < grid[0].length; i++) {
            ans[i] = dropBall(grid, i);
        }
        return ans;
    }

    private int dropBall(int[][] grid, int x) {

        for (int j = 0; j < grid.length; j++) {
            if (grid[j][x] == 1) {
                if (x + 1 == grid[0].length || grid[j][x + 1] == -1) {
                    return -1;
                }
                x++;
            } else {
                if (x - 1 == -1 || grid[j][x - 1] == 1) {
                    return -1;
                }
                x--;
            }
        }
        return x;
    }

    @Test
    public void test_1() {
        int[][] grid = {{1, 1, 1, -1, -1}, {1, 1, 1, -1, -1}, {-1, -1, -1, 1, 1}, {1, 1, 1, 1, -1}, {-1, -1, -1, -1, -1}};
        int[] ans = {1, -1, -1, -1, -1};
        Assertions.assertArrayEquals(ans, findBall(grid));
    }
}
