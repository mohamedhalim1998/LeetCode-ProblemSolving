import org.junit.jupiter.api.Test;

import java.util.Map;

public class LeetCode_1668 {

    public int maxRepeating(String sequence, String word) {
        int max = 0;
        int count = 0;
        int s = 0;
        for (int i = 0; i < sequence.length(); i++) {
            if (sequence.charAt(i) == word.charAt(0)) {
                if (s == 0) {
                    s = i;
                }
                boolean matched = true;
                int j = 0, k = i;
                for (; j < word.length() && k < sequence.length(); j++, k++) {
                    if (sequence.charAt(k) != word.charAt(j)) {
                        matched = false;
                    }
                }
                if (matched && j == word.length()) {
                    count++;
                    i += word.length() - 1;
                } else {
                    max = Math.max(count, max);
                    count = 0;
                    i = s;
                    s = 0;
                }

            }else {
                max = Math.max(count, max);

            }
        }
        return Math.max(count, max);
    }

    @Test
    public void test1() {
        maxRepeating("baba", "b");
    }
}
