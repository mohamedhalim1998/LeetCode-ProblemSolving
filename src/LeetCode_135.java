import java.util.Arrays;

public class LeetCode_135 {
    public int candy(int[] ratings) {
        int n = ratings.length;
        if (n == 1)
            return 1;
        int[] ans = new int[ratings.length];
        Arrays.fill(ans, 1);
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                ans[i] = Math.max(ans[i - 1] + 1, ans[i]);
            }
        }
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                ans[i] = Math.max(ans[i + 1] + 1, ans[i]);
            }
        }

        return Arrays.stream(ans).sum();
    }
}
