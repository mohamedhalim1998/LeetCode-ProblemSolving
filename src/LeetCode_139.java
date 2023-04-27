import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class LeetCode_139 {
    int[] memo;

    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        memo = new int[s.length() + 1];

        return breakWord(s, 0, set);
    }

    private boolean breakWord(String s, int start, HashSet<String> set) {
        if (start >= s.length())
            return true;
        if (memo[start] == -1)
            return false;
        if (memo[start] == 1)
            return true;
        boolean res = false;

        for (int i = start; i < s.length(); i++) {
            res = set.contains(s.substring(start, i + 1)) && breakWord(s, i + 1, set);

            if (res) {
                memo[start] = 1;
                return true;
            } else {
                memo[start] = -1;
            }
        }
        return false;
    }


    @Test
    public void test() {
        String word = "leetcode";
        List<String> list = List.of("leet", "code");
        Assertions.assertTrue(wordBreak(word, list));
    }

    @Test
    public void test2() {
        String word = "bb";
        List<String> list = List.of("a", "b", "bbb", "bbbb");
        Assertions.assertTrue(wordBreak(word, list));
    }

    @Test
    public void test3() {
        String word = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
        List<String> list = List.of("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa");
        Assertions.assertFalse(wordBreak(word, list));
    }
}
