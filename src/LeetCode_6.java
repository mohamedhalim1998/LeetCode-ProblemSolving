import java.util.ArrayList;
import java.util.Collection;

public class LeetCode_6 {
    public String convert(String s, int numRows) {
        ArrayList<ArrayList<Character>> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            rows.add(new ArrayList<>());
        }
        int i = 0;
        boolean rev = false;
        while (i < s.length()) {
            if(rev) {
                for (int j = numRows - 2; j > 0 ; j--) {
                    rows.get(j).add(s.charAt(i++));
                }
                rev = false;
            } else {
                for (int j =0; j < numRows ; j++) {
                    rows.get(j).add(s.charAt(i++));
                }
                rev = true;
            }
        }
        return rows.stream().flatMap(Collection::stream).collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
    }
}
