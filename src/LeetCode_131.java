import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_131 {
    public List<List<String>> partition(String s) {
        ArrayList<Palindrome> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String sub = s.substring(i, j + 1);
                if (isPalindrome(sub)) {
                    list.add(new Palindrome(sub, i, j));
                }
            }
        }
        List<List<String>> ans = new ArrayList<>();
        partition(list, ans, new ArrayList<>(), 0, s.length());
        System.out.println(ans);
        return ans;


    }

    private void partition(ArrayList<Palindrome> list, List<List<String>> ans, List<String> curr, int start, int length) {
        if (start == length) {
            ans.add(curr);
            return;
        }
        for (Palindrome p : list) {
            if (p.l == start) {
                List<String> copy = new ArrayList<>(curr);
                copy.add(p.s);
                partition(list, ans, copy, p.r + 1, length);
            }
        }
    }

    public boolean isPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j))
                return false;

        }
        return true;
    }

    class Palindrome {
        String s;
        int l, r;

        public Palindrome(String s, int l, int r) {
            this.s = s;
            this.l = l;
            this.r = r;
        }
    }

    @Test
    public void test() {
        partition("aab");
    }
}
