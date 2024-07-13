import org.junit.jupiter.api.Test;

public class LeetCode_875 {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 0;
        int high = Integer.MAX_VALUE;
        int mid = low + (high - low) / 2;
        int ans = mid;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if(checkMid(piles, mid, h)) {
                high = mid - 1;
                ans =mid;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private boolean checkMid(int[] piles, int mid, int h) {
        long count = 0;
        for(int x : piles) {
            if(x < mid) {
                count++;
            } else {
                count += (int) Math.ceil(x / (mid * 1.0));
            }
        }
        return count <= h;
    }

    @Test
    public void test1() {
        System.out.println(minEatingSpeed(new int[]{805306368,805306368,805306368}, 1000000000));
    }
}
