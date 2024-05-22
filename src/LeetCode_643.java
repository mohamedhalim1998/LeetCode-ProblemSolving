import java.util.Map;

public class LeetCode_643 {
    public double findMaxAverage(int[] nums, int k) {
        double maxAvg;
        double avg = 0;
        for(int i = 0; i < k; i++) {
            avg += nums[i];
        }
        maxAvg = avg;
        for (int i = k; i < nums.length; i++) {
            avg += nums[i];
            avg -= nums[i - k];
            maxAvg = Math.max(maxAvg, avg);
        }
        return maxAvg / k;
    }
}
