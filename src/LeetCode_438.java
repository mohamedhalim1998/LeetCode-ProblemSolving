import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class LeetCode_438 {
    public List<Integer> findAnagrams(String s, String p) {
        if (s.length() < p.length())
            return new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        int[] freqP = new int[26];
        int[] freqS = new int[26];
        for (char c : p.toCharArray()) {
            freqP[c - 'a']++;
        }
        for (int i = 0; i < p.length(); i++) {
            freqS[s.charAt(i) - 'a']++;
        }
        int l = 0;
        if(Arrays.equals(freqP, freqS)) {
            ans.add(l);
        }
        for (int i = p.length(); i < s.length(); i++) {
            freqS[s.charAt(l) - 'a']--;
            l++;
            freqS[s.charAt(i) - 'a']++;
            if(Arrays.equals(freqP, freqS)) {
                ans.add(l);
            }
        }

        return ans;
    }

    @Test
    public void test_1() {
        List<Integer> list = List.of(0, 6);
        Assertions.assertEquals(list, findAnagrams("cbaebabacd", "abc"));
    }
}
