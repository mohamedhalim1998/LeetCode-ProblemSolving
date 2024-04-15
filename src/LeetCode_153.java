import org.junit.Test;

public class LeetCode_153 {
    public int findMin(int[] nums) {
        return findMin(nums, 0, nums.length - 1);
    }

    private int findMin(int[] nums, int l, int r) {
        if (r <= l)
            return nums[l];
        int m = (r - l) / 2 + l;
        if (nums[l] > nums[r]) {
            if (nums[m] >= nums[l]) {
                return findMin(nums, m + 1, r);
            } else {
                return findMin(nums, l, m);
            }
        } else {
            if (nums[m] < nums[l]) {
                return findMin(nums, m + 1, r);
            } else {
                return findMin(nums, l, m);
            }
        }
    }

    @Test
    public void test1() {
        System.out.println(findMin(new int[]{3,1,2}));
    }
}
