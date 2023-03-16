import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LeetCode_424 {
    public int characterReplacement(String s, int k) {
        int max = 0;
        for (char c = 'A'; c <= 'Z'; c++) {
            int ch = 0;
            int other = 0;
            int start = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == c) {
                    ch++;
                } else if (other < k) {
                    other++;
                } else {
                    max = Math.max(max, i - start);
                    if (s.charAt(start) == c) {
                        ch--;
                    } else {
                        other--;
                    }
                    i--;
                    start++;
                }
            }
            max = Math.max(max, s.length() - start);

        }

        return max;
    }
    @Test
    public void test_1() {
        Assertions.assertEquals(4, characterReplacement("ABAB", 2));
    }
    @Test
    public void test_2() {
        Assertions.assertEquals(4, characterReplacement("AABABBA", 1));
    }


}
