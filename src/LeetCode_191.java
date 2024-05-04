
public class LeetCode_191 {
    public int hammingWeight(int n) {
        var s = Integer.toBinaryString(n);
        int count = 0;
        for (var c : s.toCharArray()) {
            if (c == '1')
                count++;
        }
        return count;
    }
}
