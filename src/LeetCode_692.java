import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class LeetCode_692 {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> tree = new HashMap<>();
        for (String s : words) {
            tree.put(s, tree.getOrDefault(s, 0) + 1);
        }
        return tree.entrySet().stream().sorted((t1, t2) -> {
            if (!Objects.equals(t1.getValue(), t2.getValue()))
                return Integer.compare(t2.getValue(), t1.getValue());
            return t1.getKey().compareTo(t2.getKey());
        }).limit(k).map(Map.Entry::getKey).toList();
    }

    @Test
    public void test_1() {
        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        List<String> ans = List.of("i", "love");
        Assertions.assertEquals(ans, topKFrequent(words, 2));
    }

}
