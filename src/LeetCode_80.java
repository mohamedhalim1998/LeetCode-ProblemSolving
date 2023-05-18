public class LeetCode_80 {
    public int removeDuplicates(int[] nums) {
        int curr = 0;
        int k = 1;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[curr] && count < 2) {
                count++;
                curr++;
                k++;
            } else if (nums[i] != nums[curr]) {
                swap(nums, curr + 1, i);
                curr++;
                k++;
                count =1;
            }
        }
        return k;

    }

    public void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
