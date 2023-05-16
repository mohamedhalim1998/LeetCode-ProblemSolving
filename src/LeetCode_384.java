import java.util.Arrays;
import java.util.Random;

public class LeetCode_384 {
    class Solution {

        int[] arr;

        public Solution(int[] nums) {
            arr = Arrays.copyOf(nums, nums.length);
        }

        public int[] reset() {
            return arr;
        }

        public int[] shuffle() {
            int[] copy = Arrays.copyOf(arr, arr.length);
            shuffle(copy);
            return copy;
        }
        public void shuffle(int[] arr) {
            Random rnd = new Random();
            for (int i = arr.length - 1; i > 0; i--) {
                int index = rnd.nextInt(i + 1);
                int temp = arr[index];
                arr[index] = arr[i];
                arr[i] = temp;
            }
        }

    }

}
