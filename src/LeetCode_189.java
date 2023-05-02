import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class LeetCode_189 {

    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        if (k == 0)
            return;
        int[] arr = new int[nums.length];
        for (int i = nums.length - k, j = 0; j < nums.length; i++, j++) {
            int index = i % nums.length;
            arr[j] = nums[index];
        }
        System.arraycopy(arr, 0, nums, 0, nums.length);
        System.out.println(Arrays.toString(nums));
    }

    @Test
    public void test1() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        rotate(arr, 0);
    }

    @Test
    public void test2() {
        int[] arr = {1, 2, 3, 4, 5, 6};
        rotate(arr, 4);
        Assertions.assertArrayEquals(new int[]{3, 4, 5, 6, 1, 2}, arr);
    }

    @Test
    public void test3() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27};
        rotate(arr, 38);
        Assertions.assertArrayEquals(new int[]{17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16}, arr);
    }
}
