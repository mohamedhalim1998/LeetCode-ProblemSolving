import org.junit.jupiter.api.Test;

public class LeetCode_338 {
    public int[] countBits(int n) {
        int[] db = new int[n + 1];
        db[1] = 1;
        while (n > 0) {
            if (db[n] == 0) {
                countBits(n, db);
            }
            n--;
        }
        return db;
    }

    private int countBits(int n, int[] db) {
        if (n == 0) {
            return 0;
        }
        if (db[n] > 0) {
            return db[n];
        }
        int res = n % 2 + countBits(n / 2, db);
        db[n] = res;
        return res;
    }

    @Test
    public void test1() {
        countBits(5);
    }
}
