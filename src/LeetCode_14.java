public class LeetCode_14 {

    public String longestCommonPrefix(String[] strs) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 200; i++) {
            if (strs[0].length() > i) {
                char c = strs[0].charAt(i);
                boolean add = true;
                for (String s : strs) {
                    if (s.length() <= i) {
                        add = false;
                        break;
                    }  else if(s.charAt(i) != c) {
                        add = false;
                        break;
                    }

                }
                if(add) {
                    builder.append(c);
                } else {
                    break;
                }
            } else {
                break;
            }

        }
        return builder.toString();

    }
}
