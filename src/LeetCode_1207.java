import java.util.HashMap;
import java.util.HashSet;

public class LeetCode_1207 {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        var values = map.values();
        var set = new HashSet<>(values);
        return set.size() == values.size();
    }
}
