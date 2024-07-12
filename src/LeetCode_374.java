public class LeetCode_374 {
    public int guessNumber(int n) {
        int start = 1, end = n;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int g = guess(mid);
            if (g < 0) {
                end = mid - 1;
            } else if (g > 0) {
                return mid;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }


// dummy for compile
    private int guess(int n) {
        return -1;
    }
}
