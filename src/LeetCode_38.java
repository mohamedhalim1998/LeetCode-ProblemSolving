public class LeetCode_38 {
    public String countAndSay(int n) {
        if (n == 1)
            return "1";
        String s = countAndSay(n - 1);
        int count = 0;
        StringBuilder builder = new StringBuilder();
        char curr = s.charAt(0);
        for(char c : s.toCharArray()) {
            if(c == curr) {
                count++;
            } else {
                builder.append(count).append(curr);
                count = 1;
                curr = c;
            }
        }
        builder.append(count).append(curr);
        return builder.toString();

    }
}
