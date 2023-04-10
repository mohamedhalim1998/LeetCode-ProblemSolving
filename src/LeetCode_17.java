import java.util.ArrayList;
import java.util.List;

public class LeetCode_17 {
    static String[] arr = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0)
            return List.of();
        List<String> list = new ArrayList<>();
        letterCombinations(digits, 0, list, "");
        return list;
    }

    private void letterCombinations(String digits, int index, List<String> list, String curr) {
        if (index >= digits.length()) {
            list.add(curr);
            return;
        }

        for (char c : arr[Character.getNumericValue(digits.charAt(index)) - 2].toCharArray()) {
            letterCombinations(digits, index + 1, list, curr + c);
        }

    }

}
