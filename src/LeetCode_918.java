import org.junit.Test;

import java.util.Arrays;

public class LeetCode_918 {
    public int maxSubarraySumCircular(int[] nums) {
        int maxSumNonCircular = maxSubarraySum(nums);
        if(maxSumNonCircular < 0) {
            return maxSumNonCircular;
        }

        // Invert signs and find minimum sum
        int minSum = 0;
        for (int num : nums) {
            minSum += num;
        }
        int maxSumCircular = minSum + maxSubarraySum(Arrays.stream(nums).map(x -> -x).toArray());

        return Math.max(maxSumNonCircular, maxSumCircular);
    }

    public static int maxSubarraySum(int[] arr) {
        int maxSoFar = arr[0];
        int currMax = arr[0];

        for (int i = 1; i < arr.length; i++) {
            currMax = Math.max(arr[i], currMax + arr[i]);
            maxSoFar = Math.max(maxSoFar, currMax);
        }
        return maxSoFar;
    }
    @Test
    public void test() {
        int[] arr = new int[]{-3,-2,-3};
        System.out.println(maxSubarraySumCircular(arr));
    }
}
