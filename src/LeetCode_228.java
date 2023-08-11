import java.util.ArrayList;
import java.util.List;

public class LeetCode_228 {
    public List<String> summaryRanges(int[] nums) {
        int first = nums[0];
        int second = nums[0];
        var out = new ArrayList<String>();
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - 1 == nums[i - 1]) {
                second++;
            } else {
                if(first == second) {
                    out.add("" + first);
                } else {
                    out.add(first + "->" + second);
                }
                first = nums[i];
                second = nums[i];
            }
        }
        if(first == second) {
            out.add("" + first);
        } else {
            out.add(first + "->" + second);
        }
        return out;
    }
}
