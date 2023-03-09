import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_409 {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int sum = 0;
        for (Map.Entry<Character, Integer> e : map.entrySet()) {
            int div = e.getValue() / 2;
            sum += div * 2;
            map.put(e.getKey(), e.getValue() - (div * 2));
        }
        for (Map.Entry<Character, Integer> e : map.entrySet()) {
            if(e.getValue() > 0) {
                sum++;
                break;
            }
        }
        return sum;
    }

    @Test
    public void test_1() {
        Assertions.assertEquals(7, longestPalindrome("abccccdd"));
    }
}
