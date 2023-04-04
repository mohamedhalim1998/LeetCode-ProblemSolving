import java.util.Arrays;
import java.util.TreeSet;

public class LeetCode_16 {
    public int threeSumClosest(int[] nums, int target) {

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = i + 2; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (Math.abs(sum - target) < Math.abs(ans - target)) {
                        ans = sum;
                    }
                }
            }
        }
        return ans;
    }


}
