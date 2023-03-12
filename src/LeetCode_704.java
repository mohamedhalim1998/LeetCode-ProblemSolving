public class LeetCode_704 {
    public int search(int[] arr, int x) {
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
