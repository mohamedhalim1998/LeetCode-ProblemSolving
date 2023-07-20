public class LeetCode_167 {
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int index = binarySearch(numbers, target - numbers[i]);
            if(index == -1)
                continue;
            if(index != i) {
                return new int[]{i + 1, index + 1};
            } else if(i < numbers.length - 1 && numbers[i] == numbers[i + 1]) {
                return new int[]{i  + 1, i + 2};
            }

        }
        return null;

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
