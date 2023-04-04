import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class LeetCode_152 {
    public int maxProduct(int[] arr) {
        int ans = Integer.MIN_VALUE;
        int product = 1;
        // Traverse the array from left to right
        for (int i = 0; i < arr.length; i++) {
            product *= arr[i];
            ans = Math.max(ans, product);
            if (arr[i] == 0) {
                product = 1;
            }
        }

        product = 1;

        // Traverse the array from right to left
        for (int i = arr.length - 1; i >= 0; i--) {
            product *= arr[i];
            ans = Math.max(ans, product);
            if (arr[i] == 0) {
                product = 1;
            }
        }
        return ans;
    }

    @Test
    public void test1() {
        int[] nums = {-3, 0, 1, -2};
        Assertions.assertEquals(1, maxProduct(nums));

    }
    @Test
    public void test2() {
        int[] nums = {2,-5,-2,-4,3};
        Assertions.assertEquals(24, maxProduct(nums));

    }
}
