import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class LeetCode_56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (arr1, arr2) -> {
            if (arr1[0] != arr2[0])
                return Integer.compare(arr1[0], arr2[0]);
            return Integer.compare(arr1[1], arr2[1]);
        });
        ArrayList<int[]> list = new ArrayList<>();
        int l = intervals[0][0];
        int r = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > r) {
                list.add(new int[]{l, r});
                l = intervals[i][0];
            }
            r = Math.max(intervals[i][1], r);
        }
        list.add(new int[]{l, r});
        int[][] array = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }
}
