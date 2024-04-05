import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        combineOne(ans, new ArrayList<>(), candidates, target, 0);
        return ans;
    }

    private void combineOne(List<List<Integer>> ans, List<Integer> curr, int[] candidates, int remain, int start) {
        if (remain == 0) {
            ans.add(curr);
            return;
        }
        if (remain < 0) {
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            var list = new ArrayList<>(curr);
            list.add(candidates[i]);
            combineOne(ans, list, candidates, remain - candidates[i], i);
        }

    }

    @Test
    public void  test() {
        System.out.println(combinationSum(new int[]{2,3,6,7}, 7));
    }
}
