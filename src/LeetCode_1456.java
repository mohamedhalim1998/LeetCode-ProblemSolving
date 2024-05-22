import java.util.Set;

public class LeetCode_1456 {
    private final static Set<Character> vowels = Set.of('a','e','i','o','u');
    public int maxVowels(String s, int k) {
        int max;
        int curr = 0;
        for(int i = 0; i < k; i++) {
            if(vowels.contains(s.charAt(i))) {
                curr++;
            }
        }
        max = curr;
        for (int i = k; i < s.length(); i++) {
            if(vowels.contains(s.charAt(i))) {
                curr++;
            }
            if(vowels.contains(s.charAt(i - k))) {
                curr--;
            }
            max = Math.max(max, curr);
        }
        return max;
    }
}
