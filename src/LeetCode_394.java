import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Stack;

public class LeetCode_394 {
    public String decodeString(String s) {
        Stack<Integer> repeat = new Stack<>();
        Stack<String> toRepeat = new Stack<>();
        StringBuilder out = new StringBuilder();
        int i = 0;
//        while (Character.isAlphabetic(s.charAt(i))) {
//            out.append(s.charAt(i++));
//        }
        toRepeat.push("");
        while (i < s.length()) {
            if (s.charAt(i) == ']') {
                String t = toRepeat.pop();
                StringBuilder builder = new StringBuilder(t);
                int r = repeat.pop();
                while (r > 1) {
                    builder.append(t);
                    r--;
                }
                t = toRepeat.pop() + builder.toString();
                toRepeat.push(t);
                i++;
                continue;
            }
            if (Character.isDigit(s.charAt(i))) {
                repeat.push(0);
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    repeat.push(repeat.pop() * 10 + Character.getNumericValue(s.charAt(i)));
                    i++;
                }
            }
            if (i < s.length() && s.charAt(i) == '[') {
                toRepeat.push("");
                i++;
            }
            while (i < s.length() && Character.isAlphabetic(s.charAt(i))) {
                toRepeat.push(toRepeat.pop() + s.charAt(i));
                i++;
            }
        }
        return toRepeat.peek();
    }

    private String decodeString(String s, int i) {
        if (i >= s.length()) {
            return "";
        }

        if (s.charAt(i) == ']') {
            return "";
        }
        if (Character.isAlphabetic(s.charAt(i))) {
            return s.charAt(i) + decodeString(s, i + 1);
        }
        int repeat = 0;
        while (s.charAt(i) != '[') {
            repeat = repeat * 10 + Character.getNumericValue(s.charAt(i++));
        }
        i++;
        StringBuilder builder = new StringBuilder();
        while (i < s.length()) {
            if (Character.isDigit(s.charAt(i))) {
                builder.append(decodeString(s, i));
                String r = builder.toString();
                while (repeat > 1) {
                    builder.append(r);
                    repeat--;
                }
                break;
            } else if (s.charAt(i) != ']') {
                builder.append(s.charAt(i));
            } else {
                String r = builder.toString();
                while (repeat > 1) {
                    builder.append(r);
                    repeat--;
                }
                break;
            }
            i++;
        }
        return builder.append(decodeString(s, i + 1)).toString();

    }

    @Test
    public void test_1() {
        Assertions.assertEquals("aaabcbc", decodeString("3[a]2[bc]"));
    }

    @Test
    public void test_2() {
        Assertions.assertEquals("accaccacc", decodeString("3[a2[c]]"));
    }

    @Test
    public void test_3() {
        Assertions.assertEquals("abcabccdcdcdef", decodeString("2[abc]3[cd]ef"));
    }

    @Test
    public void test_4() {
        Assertions.assertEquals("zzzyypqjkjkefjkjkefjkjkefjkjkefyypqjkjkefjkjkefjkjkefjkjkefef", decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef"));
    }
    @Test
    public void test_5() {
        Assertions.assertEquals("leetcodeaaaaaaaaaaaaaaa", decodeString("leetcode15[a]"));
    }


}
