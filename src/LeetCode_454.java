import java.util.HashMap;
import java.util.HashSet;

public class LeetCode_454 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int j : nums1) {
            for (int k : nums2) {
                map.put(j + k, map.getOrDefault(j + k, 0) + 1);
            }
        }
        int count = 0;
        for (int j : nums3) {
            for (int k : nums4) {
                count += map.getOrDefault(-(j + k), 0);
            }
        }
        return count;
    }
}
