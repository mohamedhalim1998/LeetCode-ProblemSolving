import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class LeetCode_299 {
    public String getHint(String secret, String guess) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : secret.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int bull = 0;
        int cow = 0;
        for (int i = 0; i < guess.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bull++;
                map.put(secret.charAt(i), map.getOrDefault(secret.charAt(i), 0) - 1);
            }
        }
        for (int i = 0; i < guess.length(); i++) {
            if(secret.charAt(i) == guess.charAt(i)){
                continue;
            }
            if (map.getOrDefault(guess.charAt(i), 0) > 0) {
                cow++;
                map.put(guess.charAt(i), map.getOrDefault(guess.charAt(i), 0) - 1);
            }
        }
        return String.format("%dA%dB", bull, cow);

    }
    @Test
    public void test_1() {
        Assertions.assertEquals("0A4B",getHint("1122", "2211") );
    }
}
