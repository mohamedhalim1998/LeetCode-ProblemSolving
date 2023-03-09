import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class LeetCode_3 {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int start = -1;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                start = Math.max(start, map.get(c));
            }
            map.put(c, i);
            max = Math.max(max, i - start);
        }
        return max;

    }
    @Test
    public void  test_1() {
        Assertions.assertEquals(3, lengthOfLongestSubstring("abcabcbb"));
    }
    @Test
    public void  test_3() {
        Assertions.assertEquals(1, lengthOfLongestSubstring("bbbbb"));
    }
    @Test
    public void  test_2() {
        Assertions.assertEquals(3, lengthOfLongestSubstring("pwwkew"));
    }
    @Test
    public void  test_4() {
        Assertions.assertEquals(2, lengthOfLongestSubstring("abba"));
    }
}
