import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LeetCode_70 {
    static int[] memo = new int[50];
    public int climbStairs(int n) {
        if(memo[n] != 0)
            return memo[n];
        if(n == 1) {
            return 1;
        }
        if(n <= 0) {
            return 1;
        }
        return memo[n] = climbStairs(n - 1) + climbStairs(n - 2);
    }

    @Test
    public void test_1() {
        Assertions.assertEquals(3, climbStairs(3));
    }    @Test
    public void test_2() {
        Assertions.assertEquals(5, climbStairs(4));
        System.out.println(climbStairs(5));
    }
}
