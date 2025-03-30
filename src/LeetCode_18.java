import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class LeetCode_18 {
       public  List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Step 1: Sort the array
        backtrack(nums, target, 0, new ArrayList<>(), result);
        return result;
    }

    private  void backtrack(int[] nums, int target, int start, List<Integer> current, List<List<Integer>> result) {
        // Base case: If we have 4 elements
        if (current.size() == 4) {
            int sum = current.get(0) + current.get(1) + current.get(2) + current.get(3);
            if (sum == target) {
                result.add(new ArrayList<>(current)); // Add a valid quadruplet
            }
            return;
        }

        for (int i = start; i < nums.length; i++) {
            // Skip duplicates to avoid duplicate quadruplets
            if (i > start && nums[i] == nums[i - 1]) continue;

            // Prune the recursion if we already exceed the required elements
            if (current.size() < 4) {
                current.add(nums[i]);
                backtrack(nums, target, i + 1, current, result);
                current.remove(current.size() - 1); // Backtrack
            }
        }
    }
    @Test
    public void test1() {
        System.out.println(fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
    }
}

