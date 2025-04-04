import java.util.HashMap;
import java.util.HashSet;

public class LeetCode_1769 {
    public int[] minOperations(String boxes) {
        var set = new HashSet<Integer>();
        for (int i = 0; i < boxes.length(); i++) {
            if(boxes.charAt(i) == '1') {
                set.add(i);
            }
        }
        var ans = new int[boxes.length()];
        for(int i = 0; i < ans.length; i++) {
            for(var index : set) {
                ans[i] += Math.abs(index - i);
            }
        }
        return ans;
    }

}
