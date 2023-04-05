import java.util.*;

public class LeetCode_76 {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        HashMap<Character, LinkedList<Integer>> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            LinkedList<Integer> list = map.getOrDefault(s.charAt(i), new LinkedList<>());
            list.add(i);
            map.put(s.charAt(i), list);
        }
        TreeSet<Integer> tree = new TreeSet<>();
        for (char c : t.toCharArray()) {
            LinkedList<Integer> list = map.getOrDefault(c, new LinkedList<>());
            if (list.size() > 0) {
                tree.add(list.poll());
            } else {
                return "";
            }
        }
        int min =0;
        int max = s.length();
        while (true) {
            if (max - min > tree.last() - tree.first()) {
                max = tree.last();
                min = tree.first();
            }
            char c = s.charAt(tree.pollFirst());
            LinkedList<Integer> list = map.getOrDefault(c, new LinkedList<>());
            if (list.size() > 0) {
                tree.add(list.poll());
            } else {
                break;
            }
        }
        return s.substring(min, max + 1);

    }
}
