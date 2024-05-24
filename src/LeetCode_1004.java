import org.junit.jupiter.api.Test;

public class LeetCode_1004 {
    public int longestOnes(int[] nums, int k) {
        int max = 0;
        int zeros = 0;
        int s = 0;
        for(int i = 0; i < nums.length; i++) {
           if(nums[i] == 0) {
               zeros++;
           }
           if(zeros <= k) {
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
    @Test
    public void test1() {
        System.out.println(longestOnes(new int[]{1,1,1,0,0,0,1,1,1,1,0}, 2));
    }
}
