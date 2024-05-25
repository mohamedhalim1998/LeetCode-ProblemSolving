public class LeetCode_1943 {
    public int longestSubarray(int[] nums) {
        return longestOnes(nums, 1) - 1;
    }

    public int longestOnes(int[] nums, int k) {
        int max = 0;
        int zeros = 0;
        int s = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeros++;
            }
            if (zeros <= k) {
                max = Math.max(i - s + 1, max);
            } else {
                while (nums[s] != 0) {
                    s++;
                }
                s++;
                zeros--;
            }
        }
        max = Math.max(nums.length - s, max);
        return max;
    }
}
