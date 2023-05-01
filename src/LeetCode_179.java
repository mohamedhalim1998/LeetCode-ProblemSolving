import java.util.ArrayList;
import java.util.Comparator;

public class LeetCode_179 {
    public String largestNumber(int[] nums) {
        ArrayList<String> strings = new ArrayList<>();
        for (int num : nums) {
            strings.add("" + num);
        }

        String res = strings.stream().sorted((a, b) -> {
                    int compare = (a + b).compareTo(b + a);
                    return Integer.compare(0, compare);
                })
                .reduce("", String::concat).replaceAll("^0+", "");
        return  res.length() == 0 ? "0" : res;
    }
}
