import java.util.Scanner;

public class LeetCode_7 {
    static public int reverse(int x) {

        if (x >= 0) {
            StringBuilder builder = new StringBuilder();
            builder.append(x);
            try {
                return Integer.parseInt(builder.reverse().toString());
            } catch (Exception e) {
                return 0;
            }
        } else {
            StringBuilder builder = new StringBuilder();
            builder.append(-x);
            try {
                return - Integer.parseInt(builder.reverse().toString());
            } catch (Exception e) {
                return 0;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(reverse(scanner.nextInt()));
    }
}
