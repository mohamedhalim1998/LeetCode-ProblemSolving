import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class LeetCode_300 {
    int[][] mem;

    public int lengthOfLIS(int[] nums) {
        mem = new int[nums.length + 1][nums.length + 1];
        int ans = lengthOfLIS(nums, -1, 0);
        for (int[] arr : mem) {
            System.out.println(Arrays.toString(arr));
        }
        return ans;
    }

    private int lengthOfLIS(int[] nums, int prev, int curr) {
        if (curr >= nums.length)
            return 0;
        if (mem[prev + 1][curr] > 0)
            return mem[prev + 1][curr];
        if (prev == -1) {
            int max = 0;
            for (int i = curr; i < nums.length; i++) {
                max =  Math.max(max, 1 + lengthOfLIS(nums, i, i + 1));
            }
            return mem[prev + 1][curr] = max;
        }
        int max = 0;
        for (int i = curr; i < nums.length; i++) {
            if (nums[i] > nums[prev]) {
                max =  Math.max(max, 1 + lengthOfLIS(nums, i, i + 1));
            }
        }
        return mem[prev + 1][curr] = max;
    }

    @Test
    public void test1() {
        int[] arr = {10,9,2,5,3,7,101,18};
        Assertions.assertEquals(4, lengthOfLIS(arr));
    }

    @Test
    public void test2() {
        int[] arr = {7, 7, 7, 7, 7, 7, 7};
        Assertions.assertEquals(1, lengthOfLIS(arr));
    }

    @Test
    public void test3() {
        int[] arr = {0, 1, 0, 3, 2, 3};
        Assertions.assertEquals(4, lengthOfLIS(arr));
    }
}
