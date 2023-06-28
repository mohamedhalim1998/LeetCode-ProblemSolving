import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LeetCode_42 {
    public int trap(int[] height) {
        int count = 0;
        for (int i = 0; i < height.length; i++) {
            int s = 0;
            for (int j = i + 1; j < height.length; j++) {
                if (height[j] >= height[i]) {
                    count += s;
                    for (int k = i; k < j; k++) {
                        height[k] = height[i];

                    }
                    i = j - 1;
                    break;
                } else {
                    s += height[i] - height[j];
                }
            }
        }
        for (int i = height.length - 1; i >= 0; i--) {
            int s = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (height[j] > height[i]) {
                    count += s;
                    i = j + 1;
                    break;
                } else {
                    s += height[i] - height[j];
                }
            }
        }
        return count;

    }

    static class Pair {
        int l, r;

        public Pair(int l) {
            this.l = l;
        }
    }

    @Test
    public void test1() {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int ans = 6;
        Assertions.assertEquals(ans, trap(height));
    }

    @Test
    public void test2() {
        int[] height = {4, 2, 3};
        int ans = 1;
        Assertions.assertEquals(ans, trap(height));
    }    @Test
    public void test3() {
        int[] height = {9,4,5,3,2};
        int ans = 1;
        Assertions.assertEquals(ans, trap(height));
    }
}
