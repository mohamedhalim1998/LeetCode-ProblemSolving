import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

public class LeetCode_150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens) {
            switch (s) {
                case "+" -> {
                    int x = stack.pop();
                    int y = stack.pop();
                    stack.push(x + y);
                }
                case "-" -> {
                    int x = stack.pop();
                    int y = stack.pop();
                    stack.push(y- x);
                }
                case "/" -> {
                    int x = stack.pop();
                    int y = stack.pop();
                    stack.push(y / x);
                }
                case "*" -> {
                    int x = stack.pop();
                    int y = stack.pop();
                    stack.push(x * y);
                }
                default -> stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }

    @Test
    public void test() {
        Assertions.assertEquals(22, evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
    }
}
