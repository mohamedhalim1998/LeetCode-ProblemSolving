import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LeetCode_238 {
    public int[] productExceptSelf(int[] nums) {
        int prod = 1;
        int zero = 0;
        for (int x : nums) {
            if (x == 0) {
                zero++;
                if(zero == 1)
                    continue;
            }
            prod *= x;

        }
        int[] ans = new int[nums.length];
        if(zero > 1)
            return ans;
        if(zero == 1) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0)
                    ans[i] = prod;
            }
            return ans;
        }
        for (int i = 0; i < nums.length; i++) {
            ans[i] = bitDiv(prod, nums[i]);
        }
        return ans;
    }

    public static int bitDiv(long a, long b) {
        int ans = 0;
        boolean neg = a < 0 || b < 0;
        a = Math.abs(a);
        b = Math.abs(b);
        for (int i = 31; i >= 0; i--) {
            if ((b << i) <= a) {
                a -= (b << i);
                ans += (1 << i);
            }
        }
        return neg ? -ans : ans;
    }

    @Test
    public void test() {
        int[] arr = {1, 2, 3, 4};
        int[] ans = {24, 12, 8, 6};
        Assertions.assertArrayEquals(ans, productExceptSelf(arr));
    }
}
