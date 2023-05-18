import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LeetCode_27 {
    public int removeElement(int[] nums, int val) {
        int index = nums.length - 1;
        for (int i = 0; i < index; i++) {
            if (nums[i] == val) {
                swap(nums, i, index);
                index--;
                i--;
            }
        }
        return index + 1;
    }

    public void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    @Test
    public void test() {
        int[] arr = {3,2,2,3};
        Assertions.assertEquals(2, removeElement(arr, 3));
    }
}
