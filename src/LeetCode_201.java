import org.junit.jupiter.api.Test;

public class LeetCode_201 {
    public int rangeBitwiseAnd(int left, int right) {
       String a = Integer.toBinaryString(left);
       String b = Integer.toBinaryString(right);
       if(a.length() != b.length())
           return 0;
       boolean change = false;
       StringBuilder res = new StringBuilder();
       for(int i = 0 ; i < a.length(); i++) {
           if(change) {
               res.append(0);
               continue;
           }
           if(a.charAt(i) == b.charAt(i)) {
               res.append(a.charAt(i));
           } else {
               change = true;
               res.append(0);
           }
       }
       return Integer.parseInt(res.toString(), 2);
    }


    @Test
    public void test1() {
        rangeBitwiseAnd(2, 3);
    }
}
