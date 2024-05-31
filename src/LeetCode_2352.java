import java.util.ArrayList;
import java.util.HashMap;

public class LeetCode_2352 {
    public int equalPairs(int[][] grid) {
        HashMap<ArrayList<Integer>, Integer> map = new HashMap<>();
        for (var row : grid) {
            var list = fromArr(row);
            map.put(list, map.getOrDefault(list, 0) + 1);
        }
        int res  = 0;
        for (int i = 0; i < grid.length; i++) {
            int[] col = new int[grid.length];
            for (int j = 0; j < grid.length; j++) {
                col[j] = grid[j][i];
            }
            res += map.getOrDefault(fromArr(col), 0);
        }
        return res;
    }
    private ArrayList<Integer> fromArr(int[] arr) {
        var list = new ArrayList<Integer>();
        for(int i : arr) {
            list.add(i);
        }
        return list;
    }
}
