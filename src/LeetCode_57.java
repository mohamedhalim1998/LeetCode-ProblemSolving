import java.util.ArrayList;
import java.util.Arrays;

public class LeetCode_57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> list = new ArrayList<>();
        boolean added = false;
        for (var interval : intervals) {
            if (interval[0] < newInterval[0] || added) {
                list.add(interval);
            } else {
                added = true;
                list.add(newInterval);
                list.add(interval);
            }

        }
        return merge(list);
    }

    public int[][] merge(ArrayList<int[]> intervals) {
        intervals.forEach(arr -> System.out.println(Arrays.toString(arr)));
        ArrayList<int[]> list = new ArrayList<>();
        int l = intervals.get(0)[0];
        int r = intervals.get(0)[1];
        for (int i = 1; i < intervals.size(); i++) {
            if (intervals.get(i)[0] > r) {
                list.add(new int[]{l, r});
                l = intervals.get(i)[0];
            }
            r = Math.max(intervals.get(i)[1], r);
        }
        list.add(new int[]{l, r});
        int[][] array = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }
}
