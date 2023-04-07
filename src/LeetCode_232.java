import java.util.Stack;

public class LeetCode_232 {
    class MyQueue {
        Stack<Integer> in = new Stack<>();
        Stack<Integer> out = new Stack<>();

        public MyQueue() {

        }

        public void push(int x) {
            while (!out.isEmpty()) {
                in.push(out.pop());
            }
            in.push(x);
        }

        public int pop() {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
            return out.pop();
        }

        public int peek() {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
            return out.peek();

        }

        public boolean empty() {
            return out.isEmpty() && in.isEmpty();
        }
    }

}
