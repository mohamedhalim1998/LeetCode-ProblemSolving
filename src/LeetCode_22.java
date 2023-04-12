import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_22 {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        generateParenthesis(n, 1, "(", list);
        return list;
    }

    private void generateParenthesis(int pairs, int open, String curr, List<String> list) {
        if (curr.length() == pairs * 2) {
            if (open == 0) {
                System.out.println(curr);
                list.add(curr);
            }
            return;
        }
        generateParenthesis(pairs, open + 1, curr + "(", list);
        if (open > 0)
            generateParenthesis(pairs, open - 1, curr + ")", list);
    }

    @Test
    public void test2() {
        Assertions.assertEquals(5, generateParenthesis(3).size());
    }
}
