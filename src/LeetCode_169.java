import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class LeetCode_169 {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return map.entrySet().stream().max(Comparator.comparingInt(Map.Entry::getValue)).get().getKey();
    }
}
