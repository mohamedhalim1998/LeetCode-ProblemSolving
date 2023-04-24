import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class LeetCode_122 {
    int[][] mem;

    public int maxProfit(int[] prices) {
        int buy = prices[0];
        int profit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] > prices[i + 1]) {
                profit += prices[i] - buy;
                buy = prices[i + 1];
            }
        }
        profit += prices[prices.length - 1] - buy;
        return profit;
    }

    private int maxProfit(int[] prices, int curr, int bought) {
        if (curr >= prices.length)
            return 0;
        if (mem[curr][bought] != 0) {
            System.out.println("exit");
            return mem[curr][bought];
        }
        if (bought == 0)
            return mem[curr][bought] = Math.max(maxProfit(prices, curr + 1, 1) - prices[curr],
                    maxProfit(prices, curr + 1, bought));
        else
            return mem[curr][bought] = Math.max(prices[curr] + maxProfit(prices, curr + 1, 0), maxProfit(prices, curr + 1, bought));
    }

    @Test
    public void test() {
        int[] arr = {7, 1, 5, 3, 6, 4};
        Assertions.assertEquals(7,
                maxProfit(arr));

    }
}
