import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        combineOne(ans, null, 1, k, n);
        return ans;
    }

    private void combineOne(List<List<Integer>> ans, List<Integer> curr, int next, int remain, int n) {
        if (remain == 0) {
            ans.add(curr);
            return;
        }
        if (curr == null) {
            curr = new ArrayList<>();
            for (int i = next + 1; i <= n - remain + 1; i++) {
                var list = new ArrayList<Integer>();
                list.add(i);
                combineOne(ans, list, i + 1, remain - 1, n);
            }
            curr.add(next);
            combineOne(ans, curr, next + 1, remain - 1, n);
        } else {
            for (int i = next + 1; i <= n - remain + 1; i++) {
                var list = new ArrayList<Integer>(curr);
                list.add(i);
                combineOne(ans, list, i + 1, remain - 1, n);
            }
            curr.add(next);
            combineOne(ans, curr, next + 1,  remain - 1, n);
        }

    }

    @Test
    public void test() {
        combine(20, 10);
    }
}
