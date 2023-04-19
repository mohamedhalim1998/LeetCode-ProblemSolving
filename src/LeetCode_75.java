import java.util.Arrays;

public class LeetCode_75 {
    public void sortColors(int[] nums) {
        int zero = 0;
        int one = 0;
        int two = 0;
        for (int num : nums) {
            switch (num) {
                case 0 -> zero++;
                case 1 -> one++;
                case 2 -> two++;
            }
        }
        for (int i = 0; i < zero; i++) {
            nums[i] = 0;
        }
        for (int i = zero; i < zero + one; i++) {
            nums[i] = 1;
        }
        for (int i = one + zero; i < nums.length; i++) {
            nums[i] = 2;
        }
//        sortColors(nums, 0, nums.length - 1);
    }

    private void sortColors(int[] nums, int l, int r) {
        if (l >= r)
            return;
        int pivot = nums[l];
        int swap = l + 1;
        for (int i = l + 1; i <= r; i++) {
            if (nums[i] < pivot) {
                int temp = nums[swap];
                nums[swap] = nums[i];
                nums[i] = temp;
                swap++;
            }
        }
        swap--;
        nums[l] = nums[swap];
        nums[swap] = pivot;
        sortColors(nums, l, swap - 1);
        sortColors(nums, swap + 1, r);
    }
}
