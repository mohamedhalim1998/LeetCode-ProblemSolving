import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class LeetCode_371 {
    public int getSum(int a, int b) {
        String num1 = Integer.toBinaryString(a);
        String num2 = Integer.toBinaryString(b);
        char[] ans = new char[32];
        Arrays.fill(ans, '0');
        int carry = 0;
        int k = 31;
        for (int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0; i--, j--, k--) {
            char x = i >= 0 ? num1.charAt(i) : '0';
            char y = j >= 0 ? num2.charAt(j) : '0';
            if (x == '1' && y == '1') {
                ans[k] = carry == 0 ? '0' : '1';
                carry = 1;
            } else if (x == '1' || y == '1') {
                ans[k] = carry == 0 ? '1' : '0';
            } else {
                ans[k] = carry == 0 ? '0' : '1';
                carry = 0;
            }
        }
        if (carry == 1 && k >= 0)
            ans[k] = '1';
        if (ans[0] == '1') {
            for (int i = 0; i < 32; i++) {
                ans[i] = ans[i] == '0' ? '1' : '0';
            }
            return -getSum(1, Integer.parseInt(String.valueOf(ans), 2));
        }
        System.out.println(Arrays.toString(ans));
        return Integer.parseInt(String.valueOf(ans), 2);
    }

    @Test
    public void test() {
        Assertions.assertEquals(3, getSum(1, 2));
    }

    @Test
    public void test2() {
        Assertions.assertEquals(5, getSum(3, 2));
    }

    @Test
    public void test3() {
        Assertions.assertEquals(-4, getSum(-5, 1));
    }
}
