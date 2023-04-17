public class LeetCode_53 {
    public int maxSubArray(int[] nums) {
        int max_so_far = Integer.MIN_VALUE, max_ending_here
                = 0;

        for (int num : nums) {
            max_ending_here = max_ending_here + num;
            if (max_so_far < max_ending_here)
                max_so_far = max_ending_here;
            if (max_ending_here < 0)
                max_ending_here = 0;
        }
        return max_so_far;
    }

    private int maxSubArray(int[] nums, int curr, int sum) {
        if (curr >= nums.length)
            return sum;
        int max = sum;
        max = Math.max(max, maxSubArray(nums, curr + 1, 0));
        max = Math.max(max, maxSubArray(nums, curr + 1, sum + nums[curr]));
        return max;
    }
}
