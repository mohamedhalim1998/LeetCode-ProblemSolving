import java.util.Arrays;

public class LeetCode_274 {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        for (int i = 0; i < citations.length; i++, n--) {
            if(n <= citations[i])
                return n;
        }
        return 0;
    }
}
