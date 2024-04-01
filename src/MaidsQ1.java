import java.util.ArrayList;
import java.util.HashMap;

public class MaidsQ1 {


    public static int[][] findUniqueTriples(int[] arr, int sum) {
        var map = new HashMap<Integer, Integer>();
        for(int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }
        ArrayList<int[]> ans = new ArrayList<>();
        for(int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int twoSum = arr[i] + arr[j];
                int remain = sum - twoSum;
                if(map.containsKey(remain) && map.get(remain) != i && map.get(remain) != j) {
                    ans.add(new int[]{i, j, map.get(remain)});
                }
            }
        }
        return ans.toArray(int[][]::new);
    }
}
