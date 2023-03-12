public class LeetCode_278 {
    public int firstBadVersion(int n) {
        int start = 0, end = n;
        int ans = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isBadVersion(mid)) {
                end = mid - 1;
                ans = mid;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }

    private boolean isBadVersion(int mid) {
        return false;
    }
}
