import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class LeetCode_1679 {
    public int maxOperations(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int num : nums) {
            if (map.getOrDefault(k - num, 0) > 0) {
                map.put(k - num, map.get(k - num) - 1);
                res++;
            } else {
                map.put(num, map.getOrDefault(num, 0) + 1);

            }
        }
        return res;
    }
    @Test
    public void test() {
        maxOperations(new int[]{1,2,3,4}, 5);
    }
}
