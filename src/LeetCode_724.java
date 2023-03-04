import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LeetCode_724 {
    public int pivotIndex(int[] nums) {
        int[] sums = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            if (sums[i] == sums[nums.length] - sums[i + 1]) {
                return i;
            }
        }
        return -1;
    }

    @Test
    public void test_1() {
        Assertions.assertEquals(3, pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
    }

    @Test
    public void test_2() {
        Assertions.assertEquals(-1, pivotIndex(new int[]{1, 2, 3}));
    }

    @Test
    public void test_3() {
        Assertions.assertEquals(0, pivotIndex(new int[]{2, 1, -1}));
    }

}
