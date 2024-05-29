import java.util.HashMap;
import java.util.Map;

public class LeetCode_1657 {
    public boolean closeStrings(String word1, String word2) {
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for (char c : word1.toCharArray()) {
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }
        for (char c : word2.toCharArray()) {
            if (!map1.containsKey(c)) {
                return false;
            }
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        }
        HashMap<Integer, Integer> values1 = new HashMap<>();
        HashMap<Integer, Integer> values2 = new HashMap<>();
        for(var e : map1.entrySet()) {
            values1.put(e.getValue(), values1.getOrDefault(e.getValue(), 0) + 1);
        }
        for(var e : map2.entrySet()) {
            values2.put(e.getValue(), values2.getOrDefault(e.getValue(), 0) + 1);
        }
        return values1.equals(values2);
    }
}
