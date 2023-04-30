public class LeetCode_162 {
    public int findPeakElement(int[] nums) {
        if (nums.length == 1)
            return 0;
        return findPeakElement(nums, 0, nums.length - 1);
    }


    private int findPeakElement(int[] nums, int l, int r) {
        if (l > r)
            return -1;
        int mid = l + (r - l) / 2;
        if (mid == 0 && nums[mid] > nums[mid + 1]) {
            return mid;
        } else if (mid == nums.length - 1 && nums[mid] > nums[mid - 1]) {
            return mid;
        } else if (nums[mid] > nums[mid + 1] && nums[mid] > nums[mid - 1]) {
            return mid;
        }
        int left = findPeakElement(nums, l, mid - 1);
        if (left != -1)
            return left;
        return findPeakElement(nums, mid + 1, r);

    }
}
