import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class LeetCode_205 {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> sMap = new HashMap<>();
        HashMap<Character, Character> tMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (sMap.get(c1) == null && tMap.get(c2) == null) {
                tMap.put(c2, c1);
                sMap.put(c1, c2);
            } else if (!Objects.equals(sMap.get(c1), c2)) {
                return false;
            }
        }
        return true;

    }

    @Test
    public void test_1() {
        Assertions.assertTrue(isIsomorphic("egg", "add"));
    }

    @Test
    public void test_2() {
        Assertions.assertFalse(isIsomorphic("foo", "bar"));
    }

    @Test
    public void test_3() {
        Assertions.assertTrue(isIsomorphic("paper", "title"));
    }
}
