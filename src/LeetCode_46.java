import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode_46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        permute(nums, 0, ans, Arrays.asList(new Integer[nums.length]));
        return ans;
    }

    private void permute(int[] nums, int curr, List<List<Integer>> ans, List<Integer> permutation) {
        if (curr >= nums.length) {
            ans.add(permutation);
            return;
        }
        for (int x : nums) {
            if (!permutation.contains(x)) {
                ArrayList<Integer> list = new ArrayList<>(permutation);
                list.set(curr, x);
                permute(nums, curr + 1, ans, list);
            }
        }


    }
}
