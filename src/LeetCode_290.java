import java.util.HashMap;
import java.util.Objects;

public class LeetCode_290 {
    public boolean wordPattern(String pattern, String s) {
        var patternMap = new HashMap<Character, Integer>();
        var wordMap = new HashMap<String, Integer>();
        var words  = s.split(" ");
        if(words.length != pattern.length()) {
            return false;
        }
        for(int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String w = words[i];
            if(wordMap.containsKey(w)) {
                if(!Objects.equals(patternMap.getOrDefault(c, -1), wordMap.get(w))) {
                    return false;
                }
            } else if(patternMap.containsKey(c)){
                return false;
            } else {
                wordMap.put(w, i);
                patternMap.put( c, i);
            }
        }
        return true;
    }
}
