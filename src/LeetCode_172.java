import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LeetCode_172 {
    public int trailingZeroes(int n) {
        if (n < 5)
            return 0;
        if (n < 10)
            return 1;
        int count = 0;
        for (int i = 5; i <= n; i+=5) {
            int num = i;
            while (num % 10 == 0) {
                count++;
                num /= 10;
            }
            while (num % 5 == 0) {
                count++;
                num /= 5;
            }
        }
        return count;
    }

    public static int log5(int N) {
        return (int) (Math.log(N) / Math.log(5));
    }

    @Test
    public void test1() {
        Assertions.assertEquals(2, trailingZeroes(10));
    }

    @Test
    public void test2() {
        Assertions.assertEquals(3, trailingZeroes(15));
    }

    @Test
    public void test3() {
        Assertions.assertEquals(4, trailingZeroes(20));
    }

    @Test
    public void test4() {
        Assertions.assertEquals(24, trailingZeroes(100));
    }
}
