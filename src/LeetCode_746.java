import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LeetCode_746 {
    int[] mem = new int[1001];

    public int minCostClimbingStairs(int[] cost) {
        return Math.min(minCostClimbingStairs(cost, 0), minCostClimbingStairs(cost, 1));
    }

    private int minCostClimbingStairs(int[] cost, int i) {
        if (i >= cost.length)
            return 0;

        if (mem[i] > 0) {
            System.out.println("from memory");
            return mem[i];
        }
        return mem[i] = cost[i] + Math.min(minCostClimbingStairs(cost, i + 1), minCostClimbingStairs(cost, i + 2));
    }

    @Test
    public void test_1() {
        int[] cost = {10, 15, 20};
        int ans = 15;
        Assertions.assertEquals(ans, minCostClimbingStairs(cost));
    }

    @Test
    public void test_2() {
        int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        int ans = 6;
        Assertions.assertEquals(ans, minCostClimbingStairs(cost));
    }
}
