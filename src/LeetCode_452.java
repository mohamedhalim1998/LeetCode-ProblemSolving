import java.util.Arrays;

public class LeetCode_452 {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (arr1, arr2) -> {
            if (arr1[0] != arr2[0])
                return Integer.compare(arr1[0], arr2[0]);
            return Integer.compare(arr1[1], arr2[1]);
        });
        Arrays.stream(points).forEach(arr -> System.out.println(Arrays.toString(arr)));
        int[] start = points[0];
        int count = points.length;
        for(int i = 1; i < points.length ; i++) {
            if(isOverlapping(start, points[i])) {
                count--;
                start = getOverLapInterval(start, points[i]);
            } else {
                start = points[i];
            }
        }
        return count;
    }

    private int[] getOverLapInterval(int[] start, int[] point) {
        int[] nums = {start[0], start[1], point[0], point[1]};
        Arrays.sort(nums);
        return new int[] {nums[1], nums[2]};
    }

    private boolean isOverlapping(int[] arr1, int[] arr2) {
        return arr1[1] >= arr2[0];
    }
}
