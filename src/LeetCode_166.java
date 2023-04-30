import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class LeetCode_166 {
    public String fractionToDecimal(int a, int b) {
        HashMap<Long, Integer> map = new HashMap<>();
        StringBuilder builder = new StringBuilder();
        long numerator = Math.abs((long) a);
        long denominator = Math.abs((long) b);
        long div = numerator / denominator;
        numerator = numerator % denominator;
        if (a < 0 ^ b < 0 && a != 0) {
            builder.append("-");
        }
        builder.append(div);
        if (numerator > 0) {
            builder.append('.');
        }
        while (numerator != 0) {
            if (numerator < denominator) {
                numerator *= 10;
            }
            div = numerator / denominator;
            numerator = numerator % denominator;
            builder.append(div);
            if (div == 0)
                continue;
            if (map.containsKey(numerator)) {
                builder.append(')');
                builder.insert((int) map.get(numerator), '(');
                break;
            }
            map.put(numerator, builder.length());
        }
        return builder.toString();
    }

    @Test
    public void test1() {
        Assertions.assertEquals("0.1(6)", fractionToDecimal(1, 6));
    }

    @Test
    public void test2() {
        Assertions.assertEquals("0.1(6)", fractionToDecimal(-1, -2147483648));
    }
}
