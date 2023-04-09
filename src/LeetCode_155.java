import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class LeetCode_155 {
    class MinStack {
        Stack<Node> stack = new Stack<>();
        int min = Integer.MAX_VALUE;

        public MinStack() {

        }

        public void push(int val) {
            min = Math.min(min, val);
            stack.push(new Node(val, min));
        }

        public void pop() {
            stack.pop();
            if(stack.isEmpty())
                min = Integer.MAX_VALUE;
            else
                min = stack.peek().min;
        }

        public int top() {
            return stack.peek().val;
        }

        public int getMin() {
            return stack.peek().min;
        }

        static class Node {
            int val, min;

            public Node(int val, int min) {
                this.val = val;
                this.min = min;
            }
        }
    }

}
