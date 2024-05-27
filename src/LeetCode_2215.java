import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetCode_2215 {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for (int i : nums1) {
            set1.add(i);
        }
        Set<Integer> set2 = new HashSet<>();
        for (int i : nums2) {
            set2.add(i);
        }
        List<List<Integer>> ans = List.of(new ArrayList<>(), new ArrayList<>());
        for (int i : set2) {
            if(!set1.contains(i)) {
                ans.get(1).add(i);
            }
        }
        for (int i : set1) {
            if(!set2.contains(i)) {
                ans.get(0).add(i);
            }
        }
        return ans;
    }
}
