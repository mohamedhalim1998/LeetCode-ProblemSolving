import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LeetCode_443 {

    public int compress(char[] chars) {
        int sum = 0;
        char curr = chars[0];
        int count = 1;
        int change = 0;
        for (int i = 1; i < chars.length; i++) {
            if (curr != chars[i]) {
                chars[change++] = curr;
                sum++;
                if (count != 1) {
                    String num = "" + count;
                    for(char c : num.toCharArray()) {
                        chars[change++] = c;
                        sum++;
                    }
                }
                curr = chars[i];
                count = 1;
            } else {
                count++;
            }
        }
        chars[change++] = curr;
        sum++;
        if (count != 1) {
            String num = "" + count;
            for(char c : num.toCharArray()) {
                chars[change++] = c;
                sum++;
            }
//            while (count > 0) {
//                sum++;
//                chars[change++] = Character.forDigit(count % 10, 10);
//                count = count / 10;
//            }
        }
        System.out.println(chars);
        return sum;
    }

    @Test
    public void test_1() {
        Assertions.assertEquals(6, compress(new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'}));
    }

    @Test
    public void test_2() {
        Assertions.assertEquals(1, compress(new char[]{'a'}));
    }

    @Test
    public void test_3() {
        Assertions.assertEquals(4, compress(new char[]{'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'}));
    }
}
