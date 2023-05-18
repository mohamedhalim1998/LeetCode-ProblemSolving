import java.util.Arrays;

public class LeetCode_26 {
    public int removeDuplicates(int[] nums) {
        int curr = 0;
        int k = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[curr]) {
                swap(nums, curr + 1, i);
                curr++;
                k++;
            }
        }
        return k;

    }

    public void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
