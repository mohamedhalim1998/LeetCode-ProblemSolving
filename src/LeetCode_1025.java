public class LeetCode_1025 {
    public boolean divisorGame(int n) {
        return divisorGame(n, true);
    }

    private boolean divisorGame(int n, boolean alice) {
        if(n == 1) {
            return !alice;
        }
        if(n % 2 == 0) {
            return divisorGame(n - 1, !alice);
        }
        for (int i = 2; i < n; i+=2) {
            if(n % i == 0) {
                return divisorGame(n - i, !alice);
            }
        }
        return divisorGame(n - 1, !alice);
    }
}
