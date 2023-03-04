import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class LeetCode_1480 {
    public int[] runningSum(int[] nums) {
        int[] sums = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
        return Arrays.copyOfRange(sums, 1, nums.length + 1);
    }

    @Test
    public void test_1() {
        int[] ans = runningSum(new int[]{1, 2, 3, 4});
        Assertions.assertArrayEquals(
                new int[]{1, 3, 6, 10}, ans

        );
    }


}
