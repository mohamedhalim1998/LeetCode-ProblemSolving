import org.junit.Test;

public class LeetCode_35 {
    public int searchInsert(int[] nums, int target) {
        return searchInsert(nums, target, 0, nums.length-1);
    }

    private int searchInsert(int[] nums, int target, int l, int r) {
        if(l > r)
            return l;
        int m = (r - l)+ l / 2;
        if(nums[m] == target) {
            return m;
        }
        if(nums[m] > target) {
            return searchInsert(nums, target, l, m - 1);
        }
        return searchInsert(nums, target, m + 1, r);
    }

    @Test
    public void test1() {
        System.out.println(searchInsert(new int[]{1,3,5,6}, 2));
    }
}
