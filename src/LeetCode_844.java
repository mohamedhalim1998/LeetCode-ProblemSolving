import java.util.Stack;

public class LeetCode_844 {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> sStack = new Stack<>();
        Stack<Character> tStack = new Stack<>();
        for(char c : s.toCharArray()) {
            if(c =='#') {
                if(!sStack.empty()) {
                    sStack.pop();
                }
            } else {
                sStack.push(c);
            }
        }
        for(char c : t.toCharArray()) {
            if(c =='#') {
                if(!tStack.empty()) {
                    tStack.pop();
                }
            } else {
                tStack.push(c);
            }
        }
        return sStack.equals(tStack);

    }
}
