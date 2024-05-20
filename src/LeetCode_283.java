import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class LeetCode_283 {
    public void moveZeroes(int[] nums) {
        int s = 0;
        while (s < nums.length && nums[s] != 0) {
            s++;
        }
        if(s == nums.length) return;
        int z = 1;
        for (int i = s + 1; i < nums.length; i++) {
            if(nums[i] != 0) {
                nums[s] = nums[i];
                s++;
            } else {
                z++;
            }
        }
        int i = nums.length - 1;
        while (z > 0) {
            nums[i] = 0;
            z--;
            i--;
        }
    }

    public void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    @Test
    public void test1() {
        int[] nums = new int[]{2, 0, 1};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
