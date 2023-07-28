import org.junit.jupiter.api.Test;

import java.util.*;

public class LeetCode_30 {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> list = new ArrayList<>();
        var map = arrToFreqMap(words);
        int len = words[0].length();
        int totalCharCount = words.length * len;

        for (int i = 0; i <= s.length() - totalCharCount; i++) {
            Map<String, Integer> currentWordDict = new HashMap<>();
            for (int j = 0; j < words.length; j++) {// Time complexity: O(i * j)
                int nextWordIndex = i + j * len;
                String nextWord = s.substring(nextWordIndex, nextWordIndex + len);

                if (!map.containsKey(nextWord)) {
                    break;
                }
                currentWordDict.put(nextWord, currentWordDict.getOrDefault(nextWord, 0) + 1);

                if (currentWordDict.get(nextWord) > map.getOrDefault(nextWord, 0)) {
                    break;
                }

                if (j + 1 == words.length) {
                    list.add(i);
                }
            }
        }
        return list;
    }

    static HashMap<String, Integer> arrToFreqMap(String[] arr) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String s : arr) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        return map;
    }
    @Test
    public void test1() {
        var words =  new String[]{"foo","bar"};
        var s = "barfoothefoobarman";
        System.out.println(findSubstring(s, words));
    }
    @Test
    public void test2() {
        var words =  new String[]{"foo","bar", "the"};
        var s = "barfoofoobarthefoobarman";
        System.out.println(findSubstring(s, words));
    }
}
