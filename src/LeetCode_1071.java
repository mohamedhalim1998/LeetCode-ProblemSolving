import org.junit.jupiter.api.Test;

import java.util.Objects;

public class LeetCode_1071 {
    public String gcdOfStrings(String str1, String str2) {
        if(str2.length() > str1.length()){
            return gcdOfStrings(str2, str1);
        }
        var builder = new StringBuilder(str2);
        while (!builder.isEmpty()) {
            var res1 = str1.replaceAll(builder.toString(), "");
            var res2 = str2.replaceAll(builder.toString(), "");
          if (Objects.equals("", res1) && Objects.equals("", res2)) {
                return builder.toString();
            } else {
                builder.delete(builder.length() - 1, builder.length());
            }
        }
        return "";
    }
    @Test
    public void test1() {
        gcdOfStrings("TAUXXTAUXXTAUXXTAUXXTAUXX", "TAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXX");
    }
}
