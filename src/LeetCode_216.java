import java.util.ArrayList;
import java.util.List;

public class LeetCode_216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        var list = new ArrayList<List<Integer>>();
        combinationSum3(k, n, list, new ArrayList<>(), 0, 1);
        return list;
    }

    private void combinationSum3(int k, int n, ArrayList<List<Integer>> list, ArrayList<Integer> es, int sum, int s) {
        if (sum > n) {
            return;
        }
        if (sum != n && es.size() == k) {
            return;
        }
        if (sum == n && es.size() == k) {
            list.add(new ArrayList<>(es));
            return;
        }
        for (int i = s; i <= 9; i++) {
            es.add(i);
            combinationSum3(k, n, list, es, sum + i, i + 1);
            es.remove(es.size() - 1);
        }
    }
}
