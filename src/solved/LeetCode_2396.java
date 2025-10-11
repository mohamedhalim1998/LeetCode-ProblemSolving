package solved;

public class LeetCode_2396 {
    public boolean isStrictlyPalindromic(int n) {
        for (int i = 2; i < n - 1; i++) {
            if(!isPalindromic(Integer.toUnsignedString(n, i))) {
                return false;
            }
        }
        return true;
    }

    private boolean isPalindromic(String unsignedString) {
        var builder = new StringBuilder();
        builder.append(unsignedString);
        return  builder.toString().equalsIgnoreCase(builder.reverse().toString());
    }
}
