import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class LeetCode_322 {
    int[] mem = new int[(int) (1e4 + 9)];

    public int coinChange(int[] coins, int amount) {
        Arrays.fill(mem, -1);
        int res = coinChange(coins, amount, 0);
        if (res >= Short.MAX_VALUE) {
            return -1;
        }
        return res;
    }

    private int coinChange(int[] coins, int amount, int iteration) {
        if (amount == 0) {
            return 0;
        }
        if (mem[amount] != -1)
            return mem[amount];
        int min = Short.MAX_VALUE;
        for (int coin : coins) {
            if (coin <= amount) {
                min = Math.min(1 + coinChange(coins, amount - coin, iteration + 1), min);
            }
        }

        return mem[amount] = min;
    }



    @Test
    public void test_1() {
        int[] arr = {1, 2, 5};
        int amount = 11;
        Assertions.assertEquals(3, coinChange(arr, amount));
    }

    @Test
    public void test_2() {
        int[] arr = {186, 419, 83, 408};
        int amount = 6249;
        Assertions.assertEquals(20, coinChange(arr, amount));
    }
}
