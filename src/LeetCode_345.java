import java.util.Set;
import java.util.Stack;

public class LeetCode_345 {
    public String reverseVowels(String s) {
        var vowels = Set.of('a','e','i','o','u');
        var stack = new Stack<Character>();
        var chars = s.toCharArray();
        for(var c : chars) {
            if(vowels.contains(c)){
                stack.push(c);
            }
        }
        for(int i = 0; i < s.length(); i++) {
            if(vowels.contains(chars[i])){
                chars[i] = stack.pop();
            }
        }
        return String.valueOf(chars);
    }
}
