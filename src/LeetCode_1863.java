import java.util.ArrayList;

public class LeetCode_1863 {
    public int subsetXORSum(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < (1 << n); i++) {
            int curr = 0;
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    curr = curr ^ nums[j];
                }
            }
            sum += curr;
        }
        return sum;

    }


//    private int subsetXORSum(int[] nums, int index, int res) {
//        if (index > nums.length) {
//            return 0;
//        }
//
//        return nums[index] + subsetXORSum(nums, index + 1, 0) + subsetXORSum(nums, index + 1, res ^ nums[index]);
//    }
}
