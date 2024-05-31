import java.util.Stack;

public class LeetCode_2390 {
    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()) {
            if(c == '*') {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()){
            builder.append(stack.pop());
        }
        return builder.reverse().toString();
    }
}
