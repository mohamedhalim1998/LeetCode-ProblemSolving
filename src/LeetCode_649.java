import java.util.LinkedList;
import java.util.List;

public class LeetCode_649 {
    public String predictPartyVictory(String senate) {
        LinkedList<Character> list = new LinkedList<>();
        int r = 0, d = 0;
        for (var c : senate.toCharArray()) {
            list.add(c);
            if(c == 'R') {
                r++;
            } else {
                d++;
            }
        }
        int skipR = 0, skipD = 0;
        while (r > 0 && d > 0) {
            char c = list.remove();
            if(c == 'R') {
                if(skipR > 0) {
                    skipR--;
                } else {
                    skipD++;
                    d--;
                    list.add(c);
                }
            } else {
                if(skipD > 0) {
                    skipD--;
                } else {
                    skipR++;
                    r--;
                    list.add(c);
                }
            }
        }
        return r > 0 ? "Radiant" : "Dire";
    }
}
