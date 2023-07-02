import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LeetCode_12 {
    public String intToRoman(int num) {
        /**
         * I             1
         * V             5
         * X             10
         * L             50
         * C             100
         * D             500
         * M             1000
         * I can be placed before V (5) and X (10) to make 4 and 9.
         * X can be placed before L (50) and C (100) to make 40 and 90.
         * C can be placed before D (500) and M (1000) to make 400 and 900.
         */
        StringBuilder out = new StringBuilder();
        while (num > 0) {
            if (num >= 1000) {
                num -= 1000;
                out.append('M');
            } else if (num >= 900) {
                num -= 900;
                out.append("CM");
            } else if (num >= 500) {
                num -= 500;
                out.append("D");
            } else if (num >= 400) {
                num -= 400;
                out.append("CD");
            } else if (num >= 100) {
                num -= 100;
                out.append("C");
            } else if (num >= 90) {
                num -= 90;
                out.append("XC");
            } else if (num >= 50) {
                num -= 50;
                out.append("L");
            } else if (num >= 40) {
                num -= 40;
                out.append("XL");
            } else if (num >= 10) {
                num -= 10;
                out.append("X");
            } else if (num >= 9) {
                num -= 9;
                out.append("IX");
            } else if (num >= 5) {
                num -= 5;
                out.append("V");
            } else if (num >= 4) {
                num -= 4;
                out.append("IV");
            } else if (num >= 1) {
                num -= 1;
                out.append("I");
            }
        }
        return out.toString();
    }

    @Test
    public void test1() {
        Assertions.assertEquals("MCMXCIV", intToRoman(1994));
    }
}
