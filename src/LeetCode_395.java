public class LeetCode_395 {
    public int longestSubstring(String s, int n) {
        int[][] sums = new int[28][s.length() + 1];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < 28; j++) {
                sums[j][i + 1] = sums[j][i];
            }
            int index = s.charAt(i) - 'a';
            sums[index][i + 1]++;
        }
        int len = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                boolean found = true;
                for (int k = 0; k < 28; k++) {
                    if (sums[k][j] - sums[k][i] > 0 && sums[k][j] - sums[k][i] < n) {
                        found = false;
                        break;
                    }
                }
                if (found)
                    len = Math.max(len, j - i);
            }
        }
        return len;
    }
}
