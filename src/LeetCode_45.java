public class LeetCode_45 {
    int[] mem;

    public int jump(int[] nums) {
        mem = new int[nums.length];
        return jump(nums, 0);
    }

    private int jump(int[] nums, int index) {
        if (index >= nums.length)
            return 0;
        if (mem[index] != 0)
            return mem[index];
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= nums[index]; i++) {
            min = Math.min(min,1+ jump(nums, index + i));
        }
        return mem[index] = min;
    }

}