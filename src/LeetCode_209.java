import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LeetCode_209 {
    public int minSubArrayLen(int target, int[] nums) {
//        int[] sums = new int[nums.length + 1];
//        for (int i = 0; i < nums.length; i++) {
//            sums[i + 1] = sums[i] + nums[i];
//        }
        int l = 0;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if(sum < target) {
                sum += nums[i];
            } else {
                min =Math.min(min, i - l);
                sum -= nums[l];
                l++;
                i--;
            }
        }
        while (sum >= target) {
            min =Math.min(min, nums.length - l);
            sum -= nums[l];
            l++;
        }
        return min < Integer.MAX_VALUE ? min : 0;
    }

    @Test
    public void test1() {
        int[] nums = {2,3,1,2,4,3};
        int target = 7;
        Assertions.assertEquals(2, minSubArrayLen(target, nums));
    }    @Test
    public void test2() {
        int[] nums = {5,1,3,5,10,7,4,9,2,8};
        int target = 15;
        Assertions.assertEquals(2, minSubArrayLen(target, nums));
    }
}
