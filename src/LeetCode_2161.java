public class LeetCode_2161 {
    public int[] pivotArray(int[] nums, int pivot) {
        int[] ans = new int[nums.length];
        int min = 0;
        for(int i : nums) {
            if(i <= pivot) {
                min++;
            }
        }
        int l = 0;
        int r = min;
        int mid = min;
        for(int i : nums) {
            if(i < pivot) {
                nums[l++] = i;
            } else if(i == pivot) {
                nums[mid--] = i;
            } else {
                nums[r++] = i;
            }
        }
        System.gc();

        return ans;

    }
}
