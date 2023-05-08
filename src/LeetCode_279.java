import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;


public class LeetCode_279 {
    int[] mem ;
    public int numSquares(int n) {
        mem = new int[n + 1];
        ArrayList<Integer> list = new ArrayList<>();
        int x = 1;
        while (x * x <= n) {
            list.add(x * x);
            x++;
        }
        return numSquares(n, list);

    }

    private int numSquares(int n, ArrayList<Integer> list) {
        if (n <= 0)
            return 0;
        if(mem[n] > 0)
            return mem[n];
        int min = Short.MAX_VALUE;
        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i) <= n)
                min = Math.min(1 + numSquares(n - list.get(i), list), min);
        }
        return mem[n] = min;
    }

    @Test
    public void test1() {
        Assertions.assertEquals(3, numSquares(12));
    }
}
