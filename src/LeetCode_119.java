import java.util.ArrayList;
import java.util.List;

public class LeetCode_119 {
    public List<Integer> getRow(int rowIndex) {
        var ans = new ArrayList<List<Integer>>();
        ans.add(List.of(1));
        ans.add(List.of(1, 1));
        for (int i = 2; i < rowIndex; i++) {
            var list = new ArrayList<Integer>();
            var prev = ans.get(i - 1);
            list.add(1);
            for (int j = 1; j < i; j++) {
                list.add(prev.get(j - 1) + prev.get(j));
            }
            list.add(1);
            ans.add(list);
        }
        return ans.get(rowIndex);
    }

}
