import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetCode_40 {
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            List<List<Integer>> ans = new ArrayList<>();
            Arrays.sort(candidates);
            combinationSum2( candidates, target,  ans,0, new ArrayList<>());
            return ans;
        }

        private void combinationSum2(int[] candidates, int target, List<List<Integer>> list, int start, ArrayList<Integer> es) {
            if (target == 0) {
                list.add(es);
                return;
            }
            if (target < 0 || start >= candidates.length) {
                return;
            }
            for (int i = start; i < candidates.length; i++) {
                if (i > start && candidates[i] == candidates[i - 1])
                    continue;
                es.add(candidates[i]);
                combinationSum2(candidates, target - candidates[i], list, i + 1, es);
                es.remove(es.size() - 1);
            }
        }



    @Test
    public void test() {
        combinationSum2(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}, 30);
    }
}
