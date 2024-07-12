import java.util.Arrays;
import java.util.Map;

public class LeetCode_2300 {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] res = new int[spells.length];
        Arrays.sort(potions);
        for (int i = 0; i < spells.length; i++) {
            res[i] = potions.length - 1 - lessSearch(potions, (int) Math.ceil(1.0 * success / spells[i]));
        }
        return res;
    }
    static int lessSearch(int[] arr, int x) {
        int start = 0, end = arr.length - 1;

        int ans = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] >= x) {
                end = mid - 1;
            } else {
                ans = mid;
                start = mid + 1;
            }
        }
        return ans == -1 ?0 : ans;
    }

}
