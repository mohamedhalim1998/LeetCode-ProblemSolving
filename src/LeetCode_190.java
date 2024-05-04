import org.junit.jupiter.api.Test;

public class LeetCode_190 {
    public int reverseBits(int n) {
        var s = Integer.toBinaryString(n);
        var builder = new StringBuilder(s).reverse();
        while (builder.length() < 32) {
            builder.append(0);
        }
        s = builder.toString();
        int pow = 1;
        int res = 0;
        if (n < 0) {
            s = twoComplement(s);
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '1') {
                res += pow;
            }
            pow *= 2;
        }

        return n < 0 ? -res : res;
    }

    private String twoComplement(String s) {
        var arr = s.toCharArray();
        boolean foundOne = false;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (!foundOne && arr[i] == '1') {
                foundOne = true;
                continue;
            }
            arr[i] = arr[i] == '1' ? '0' : '1';
        }
        return new String(arr);
    }

    @Test
    public void test1() {
        System.out.println(reverseBits(-3));
    }
}
