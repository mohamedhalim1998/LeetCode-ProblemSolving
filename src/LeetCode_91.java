import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class LeetCode_91 {
    static int[] mem = new int[101];

    public int numDecodings(String s) {
        Arrays.fill(mem, -1);
        if (s.charAt(0) == '0')
            return 0;
        return numDecodings(s, 0);
    }

    private int numDecodings(String s, int i) {
        if (i >= s.length()) {
            System.out.println();
            return 1;
        }
        if (s.charAt(i) == '0')
            return 0;
        if (i == s.length() - 1) {
            System.out.println(s.charAt(i));
            return 1;
        }
        if(mem[i] != -1)
            return mem[i];
        if (Integer.parseInt(s.substring(i, i + 2)) > 26) {
            System.out.print(s.charAt(i) + " ");
            return mem[i] = numDecodings(s, i + 1);
        } else {
            System.out.print(s.charAt(i) + " ");
            int sum = numDecodings(s, i + 1);
            System.out.print(s.substring(i, i + 2) + " ");
            sum += numDecodings(s, i + 2);
            return mem[i] = sum;
        }
    }

    @Test
    public void test() {
        Assertions.assertEquals(2, numDecodings("12"));
    }

    @Test
    public void test2() {
        Assertions.assertEquals(3, numDecodings("226"));
    }

    @Test
    public void test3() {
        Assertions.assertEquals(2, numDecodings("11106"));
    }
}
