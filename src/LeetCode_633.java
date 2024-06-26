import java.util.LinkedHashSet;

public class LeetCode_633 {
    public boolean judgeSquareSum(int c) {
        LinkedHashSet<Long> set = new LinkedHashSet<>();
        long i = 1;
        while (i * i < Integer.MAX_VALUE) {
            set.add(i * i);
            i++;
        }
        for(var num : set) {
            if(set.contains(c - num)) {
                return true;
            }
        }
        return false;
    }
}
