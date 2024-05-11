public class LeetCode_136 {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (var num : nums) {
            res ^= num;
        }
        return res;
    }
}
