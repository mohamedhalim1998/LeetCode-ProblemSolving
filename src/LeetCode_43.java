import java.math.BigInteger;

public class LeetCode_43 {
    public  String multiply(String x, String y) {
        BigInteger a = new BigInteger(x);
        BigInteger b = new BigInteger(y);
        return a.multiply(b).toString();
    }
    public  String _multiply(String x, String y) {
        if (x.length() <= 1 && y.length() <= 1) {
            return "" + (Integer.parseInt("0" + x) * Integer.parseInt("0" + y));
        }
        String a = x.substring(0, x.length() / 2);
        String b = x.substring(x.length() / 2);
        String c = y.substring(0, y.length() / 2);
        String d = y.substring(y.length() / 2);
        String ad = _multiply(a, d);
        String bc = _multiply(b, c);
        StringBuilder ac = new StringBuilder(_multiply(a, c));
        String bd = _multiply(b, d);
        StringBuilder adbc = new StringBuilder(add(ad, bc));
        ac.append("0".repeat(x.length()));
        adbc.append("0".repeat(x.length() / 2));
        return add(add(ac.toString(), adbc.toString()), bd);
    }

    public  String add(String x, String y) {
        char[] ans = new char[Math.max(x.length(), y.length()) + 1];
        int i = x.length() - 1;
        int j = y.length() - 1;
        int k = ans.length - 1;
        int carry = 0;
        while (i >= 0 && j >= 0) {
            int sum = Character.getNumericValue(x.charAt(i)) + Character.getNumericValue(y.charAt(j)) + carry;
            i--;
            j--;
            if (sum >= 10) {
                sum -= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            ans[k--] = (char) (sum + '0');
        }
        while (i >= 0) {
            int sum = Character.getNumericValue(x.charAt(i)) + carry;
            i--;
            if (sum >= 10) {
                sum -= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            ans[k--] = (char) (sum + '0');
        }
        while (j >= 0) {
            int sum = Character.getNumericValue(y.charAt(j)) + carry;
            j--;
            if (sum >= 10) {
                sum -= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            ans[k--] = (char) (sum + '0');
        }
        ans[k] = (char) (carry + '0');
        k = 0;
        while (ans[k] == '0') {
            k++;
        }
        return String.valueOf(ans).substring(k);

    }
}
