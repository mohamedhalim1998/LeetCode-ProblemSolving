import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LeetCode_33 {
    public int search(int[] nums, int target) {
        int pivot = getPivot(nums);
        System.out.println("Pivot: " + pivot);
        while (pivot > 0 && nums[pivot - 1] < nums[pivot]) {
            pivot--;
        }
        int index = binarySearch(nums, target, 0, pivot - 1);
        if (index != -1)
            return index;
        else
            return binarySearch(nums, target, pivot, nums.length - 1);

    }

    private int getPivot(int[] nums) {
        int start = 0, end = nums.length - 1;
        int mid = start + (end - start) / 2;

        while (start < end) {
             mid = start + (end - start) / 2;
            if (nums[start] > nums[end]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return mid;
    }

    static int binarySearch(int[] arr, int x, int l, int r) {
        int start = l, end = r;
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

    @Test
    public void test_1() {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        Assertions.assertEquals(4, search(nums, 0));
    }
    @Test
    public void test_2() {
        int[] nums = {5,1,3};
        Assertions.assertEquals(1, search(nums, 1));
    }
}
