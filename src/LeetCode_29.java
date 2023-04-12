import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LeetCode_29 {
    public int divide(int dividend, int divisor) {

        boolean neg = ((dividend < 0) ^ (divisor < 0));
        long a  = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);
        int res = 0;
        while (a >= b) {
            long temp = b;
            int shiftCount = 0;
            while (a >= (temp << 1)) {
                temp <<= 1;
                shiftCount++;
            }
            res += 1 << shiftCount;
            a -= temp;
        }

        return neg ? - res : res;

    }

    @Test
    public void test1() {
        Assertions.assertEquals(Integer.MAX_VALUE / 2, divide(Integer.MAX_VALUE, 2));
    }  @Test
    public void test2() {
        Assertions.assertEquals(Integer.MIN_VALUE / -2, divide(Integer.MIN_VALUE, -2));
    }
}
