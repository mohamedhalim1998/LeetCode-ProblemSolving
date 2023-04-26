import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class LeetCode_134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sumGasLeft = 0;
        int start = 0;
        int total = 0;
        for (int i = 0; i < gas.length; i++) {
            int gasLeft = gas[i] - cost[i];
            if (sumGasLeft >= 0) {
                sumGasLeft += gasLeft;
            } else {
                sumGasLeft = gasLeft;
                start = i;
            }
            total += gasLeft;
        }
        return total < 0 ? -1 : start;
    }
    @Test
    public void test1() {
        int[] gas = {1, 2, 3, 4, 5}, cost = {3, 4, 5, 1, 2};
        Assertions.assertEquals(3, canCompleteCircuit(gas, cost));
    }
}
