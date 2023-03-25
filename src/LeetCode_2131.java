import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_2131 {
    public int longestPalindrome(String[] words) {
        HashMap<String, Integer> map = new HashMap<>();
        int size = 0;
        for (String s : words) {
          if (map.getOrDefault(reverse(s), 0) > 0) {
                map.put(reverse(s), map.get(reverse(s)) - 1);
                size += 4;
            } else {
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
        }
        int max = 0;
        for(Map.Entry<String, Integer> e : map.entrySet()) {
            if(e.getKey().charAt(0) == e.getKey().charAt(1)) {
                max = Math.max(max, 2 * e.getValue());
            }
        }
        return size + max;
    }

    private String reverse(String s) {
        return "" + s.charAt(1) + s.charAt(0);
    }

    @Test
    public void test_1() {
        String[] words = {"ll","lb","bb","bx","xx","lx","xx","lx","ll","xb","bx","lb","bb","lb","bl","bb","bx","xl","lb","xx"};
        Assertions.assertEquals(26, longestPalindrome(words));
    }
}
