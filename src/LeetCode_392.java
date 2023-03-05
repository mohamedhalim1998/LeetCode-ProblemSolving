import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LeetCode_392 {
    public boolean isSubsequence(String s, String t) {
        int i = 0;
        int j = 0;
        while (i < s.length() && j < t.length()) {
            if(s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == s.length();
    }

    @Test
    public void test_1() {
        Assertions.assertTrue(isSubsequence(
                "abc",
                "ahbgdc"
        ));
    }

    @Test
    public void test_2() {
        Assertions.assertFalse(isSubsequence(
                "axc",
                "ahbgdc"
        ));
    }
}
