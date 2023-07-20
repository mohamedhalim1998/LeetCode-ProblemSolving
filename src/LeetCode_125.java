public class LeetCode_125 {
    public boolean isPalindrome(String s) {
        StringBuilder builder = new StringBuilder();
        for(char c : s.toCharArray()) {
            if(Character.isAlphabetic(c) || Character.isDigit(c)) {
                builder.append(Character.toLowerCase(c));
            }
        }
        return builder.toString().equalsIgnoreCase(builder.reverse().toString());
    }
}
