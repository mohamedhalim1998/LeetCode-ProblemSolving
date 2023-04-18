public class LeetCode_55 {
    public boolean canJump(int[] nums) {
        if(nums.length == 1)
            return true;
        int max = nums[0];
        if (max == 0)
            return false;
        for (int i = 1; i < nums.length - 1; i++) {
            max = Math.max(max - 1, nums[i]);
            if (max == 0)
                return false;
        }
        return true;
    }
}
