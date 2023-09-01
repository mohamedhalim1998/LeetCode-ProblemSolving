import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Stack;

public class LeetCode_224 {
    public int calculate(String s) {
        return evalRPN(Objects.requireNonNull(convert(s)));

    }
    public int evalRPN(ArrayList<String> tokens) {
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
                    if(stack.isEmpty()) {
                        stack.push(-x);
                    } else {
                        int y = stack.pop();
                        stack.push(y - x);
                    }
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
    public static ArrayList<String> convert(String infix) {
        infix = infix.replaceAll("\\( *-", "(0-");
        Stack<Character> operatorStack = new Stack<>();
        ArrayList<String> postfix = new ArrayList<>();

        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);
            if(c == ' ')
                continue;
            if (Character.isDigit(c)) {
                StringBuilder numBuilder = new StringBuilder();
                numBuilder.append(c);
                while (i+1 < infix.length() && Character.isDigit(infix.charAt(i+1))) {
                    numBuilder.append(infix.charAt(i+1));
                    i++;
                }
                postfix.add(numBuilder.toString());
            } else if (c == '(') {
                operatorStack.push(c);
            } else if (c == ')') {
                while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
                    postfix.add(Character.toString(operatorStack.pop()));
                }

                if (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
                    return null;
                } else {
                    operatorStack.pop();
                }
            } else {
                while (!operatorStack.isEmpty() && precedence(c) <= precedence(operatorStack.peek())) {
                    postfix.add(Character.toString(operatorStack.pop()));
                }

                operatorStack.push(c);
            }
        }

        while (!operatorStack.isEmpty()) {
            postfix.add(Character.toString(operatorStack.pop()));
        }

        return postfix;
    }

    private static int precedence(char c) {
        return switch (c) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            case '^' -> 3;
            default -> -1;
        };
    }
    @Test
    public void test() {
        Assertions.assertEquals(3, calculate("1-(     -2)"));
    }
}
