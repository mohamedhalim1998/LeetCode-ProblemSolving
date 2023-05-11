import java.util.Arrays;

public class LeetCode_324 {
    public void wiggleSort(int[] nums) {
        if (nums.length == 1)
            return;
        int[] copy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copy);
        int n = nums.length;
        for(int i=1;i<nums.length;i+=2)
            nums[i]=copy[n--];
        for(int i=0;i<nums.length;i+=2)
            nums[i]=copy[n--];
    }
}
