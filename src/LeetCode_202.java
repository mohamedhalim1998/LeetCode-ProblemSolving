import java.util.HashSet;

public class LeetCode_202 {
    public boolean isHappy(int x) {
        HashSet<Integer> set = new HashSet<>();
        set.add(x);
        int sum = 0;
        while (sum != 1) {
            sum = 0;
            while (x > 0) {
                int digit = (int) (x % 10);
                x = x / 10;
                sum += digit * digit;
            }
            if (set.contains(sum)) {
                break;
            } else {
                set.add(sum);
                x = sum;
            }
        }
        return sum == 1;
    }
}
