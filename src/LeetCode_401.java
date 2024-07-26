import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetCode_401 {
    private int[] hours = {1, 2, 4, 8};
    private int[] min = {1, 2, 4, 8, 16, 32};

    public List<String> readBinaryWatch(int turnedOn) {
        var set = new HashSet<String>();
        readBinaryWatch(set, turnedOn, 0, 0, 0, 0);
        return new ArrayList<>(set);
    }

    private void readBinaryWatch(Set<String> set, int turnedOn, int h, int m, int hIndex, int mIndex) {
        if(h > 12) {
            return;
        }
        if(m > 59) {
            return;
        }
        if (turnedOn == 0) {
            set.add(String.format("%d:%02d", h, m));
            return;
        }

        for(int i = hIndex; i < hours.length; i++) {
            readBinaryWatch(set, turnedOn - 1, h + hours[i], m, i + 1, mIndex);
        }
        for(int i = mIndex; i < min.length; i++) {
            readBinaryWatch(set, turnedOn - 1, h, m + min[i], hIndex, i + 1);
        }

    }

    @Test
    public void test() {
        System.out.println(readBinaryWatch(9));
    }
}
