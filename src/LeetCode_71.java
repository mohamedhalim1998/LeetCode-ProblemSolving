import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class LeetCode_71 {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        for(String s : path.split("/+")) {
            switch (s) {
                case "..":
                    stack.pop();
                    break;
                case ".":
                case "":
                    break;
                default:
                    stack.push(s);
            }
        }
        StringBuilder builder = new StringBuilder("/");
        List<String> list = new ArrayList<>(stack);
        //Collections.reverse(list);
        list.forEach(a -> builder.append(a).append("/"));
        return builder.toString();
    }
    @Test
    public void test(){
        Assertions.assertEquals("/home/foo/", simplifyPath("/home//foo/"));
    }
}
