import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LeetCode_8 {
    public int myAtoi(String s) {
        s = s.trim();
        int i = 0;
        long res = 0;
        boolean pos = true;
        if (!Character.isDigit(s.charAt(0))) {
            if (s.charAt(0) == '-') {
                pos = false;
            } else if (s.charAt(0) != '+') {
                return (int) res;
            }
            i++;
        }


        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            res *= 10;
            if(pos) {
                res += Character.getNumericValue(s.charAt(i));
            } else {
                res -= Character.getNumericValue(s.charAt(i));
            }
            if(res > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            if(res < Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
            i++;
        }
        return (int) res;
    }

    @Test
    public void test1() {
        Assertions.assertEquals(23, myAtoi("23"));
    }

    @Test
    public void test2() {
        Assertions.assertEquals(23, myAtoi("0023"));
    }

    @Test
    public void test5() {
        Assertions.assertEquals(-23, myAtoi("-23"));
    }

    @Test
    public void test3() {
        Assertions.assertEquals(Integer.MAX_VALUE, myAtoi(Long.MAX_VALUE + ""));
    }

    @Test
    public void test4() {
        Assertions.assertEquals(Integer.MIN_VALUE, myAtoi(Long.MIN_VALUE + ""));
    }
}
