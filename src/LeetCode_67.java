import org.junit.jupiter.api.Test;

public class LeetCode_67 {
    public String addBinary(String a, String b) {
        boolean carry = false;
        StringBuilder builder = new StringBuilder();
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            char c1 = i >= 0 ? a.charAt(i) : '0';
            char c2 = j >= 0 ? b.charAt(j) : '0';
            if (c1 == '1' && c2 == '1') {
                if (carry) {
                    builder.append(1);
                } else {
                    builder.append(0);
                }
                carry = true;
            } else if (c1 == '1' || c2 == '1') {
                if (carry) {
                    builder.append(0);
                } else {
                    builder.append(1);
                }
            } else {
                if (carry) {
                    builder.append(1);
                    carry = false;
                } else {
                    builder.append(0);
                }
            }
        }
        if(carry) {
            builder.append(1);
        }
        return builder.reverse().toString();
    }
    @Test
    public void test1() {
        addBinary("11", "1");
    }
}
