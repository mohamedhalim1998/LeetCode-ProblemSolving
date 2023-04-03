import java.util.Arrays;

public class LeetCode_198 {
    int[] mem = new int[102];
    public int rob(int[] nums) {
        Arrays.fill(mem, -1);
        return rob(nums, 0);
    }

    private int rob(int[] nums, int i) {
        if (i >= nums.length)
            return 0;
        if(mem[i] != -1)
            return mem[i];
        return mem[i] = Math.max(nums[i] + rob(nums, i + 2), rob(nums, i + 1));
    }
}
