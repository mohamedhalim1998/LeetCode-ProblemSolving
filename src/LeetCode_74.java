public class LeetCode_74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int[] arr : matrix) {
            if (target >= arr[0] && target <= arr[matrix[0].length - 1]) {
                int index = binarySearch(arr, target);
                return index != -1;
            }
        }
        return false;
    }

    static int binarySearch(int[] arr, int x) {
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > x) {
                end = mid - 1;
            } else if (arr[mid] == x) {
                return mid;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

}
