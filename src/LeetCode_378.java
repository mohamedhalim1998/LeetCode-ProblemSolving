import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LeetCode_378 {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n-1][n-1];

        while (left < right) {
            int mid = left + (right - left)/2;
            int count = 0;
            int j = n-1;

            // count the number of elements <= mid in each row
            for (int i=0; i<n; i++) {
                while (j >= 0 && matrix[i][j] > mid) {
                    j--;
                }
                count += j+1;
            }

            // adjust boundaries based on count
            if (count < k) {
                left = mid+1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    
    @Test
    public void test(){
        int[][] mat = {{1,5,9},{10,11,13},{12,13,15}};
        int k = 8;
        Assertions.assertEquals(13, kthSmallest(mat, k));


    }
}
