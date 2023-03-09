public class LeetCode_121 {
    public int maxProfit(int[] prices) {
        int[] max = new int[prices.length + 1];
        for (int i = prices.length - 1; i >= 0; i--) {
            max[i] = Math.max(max[i + 1], prices[i]);
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            res = Math.max(res, max[i] - prices[i]);
        }
        return res;
    }
}
