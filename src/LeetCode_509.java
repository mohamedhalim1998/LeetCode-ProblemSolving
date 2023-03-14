import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LeetCode_509 {
    private static int[] memo = new int[35];

    public int fib(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (memo[n] != 0)
            return memo[n];
        return memo[n] = fib(n - 1) + fib(n - 2);
    }

    @Test
    public void test_1() {
        Assertions.assertEquals(1, fib(2));
    }

    @Test
    public void test_2() {
        Assertions.assertEquals(2, fib(3));
    }

    @Test
    public void test_3() {
        Assertions.assertEquals(3, fib(4));
    }
}
