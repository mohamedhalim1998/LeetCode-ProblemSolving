import org.junit.jupiter.api.Test;

public class LeetCode_1137 {
    public int tribonacci(int n) {
        int[] db = new int[n + 1];
        int res = tribonacci(n, db);
        return res;
    }

    private int tribonacci(int n, int[] db) {
        if(n <= 0) {
            return 0;
        }
        if(n == 1) {
            return 1;
        }
        if(n == 2) {
            return 1;
        }
        if(db[n] != 0) {
            return db[n];
        }
        int res = tribonacci(n - 1, db) + tribonacci(n - 2, db) + tribonacci(n - 3, db);
        db[n] = res;
        return res;
    }

    @Test
    public void test1() {
        tribonacci(4);
    }
}
