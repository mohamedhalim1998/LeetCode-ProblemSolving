import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LeetCode_1380 {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int[] min = calcMin(matrix);
        int[] max = calcMax(matrix);
        var ans = new ArrayList<Integer>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(min[i] == max[j]) {
                    ans.add(min[i]);
                }
            }
        }
        return ans;
    }

    private int[] calcMax(int[][] matrix) {
        int[] max = new int[matrix.length];
        for (int i = 0; i < matrix[0].length; i++) {
            max[i] = calcMax(matrix, i);
        }
        return max;
    }

    private int calcMax(int[][] matrix, int i) {
        int max = matrix[0][i];
        for (int[] ints : matrix) {
            max = Math.max(max, ints[i]);
        }
        return max;
    }

    private int[] calcMin(int[][] matrix) {
        int[] min = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            min[i] = calcMin(matrix[i]);
        }
        return min;
    }

    private int calcMin(int[] arr) {
        int min = arr[0];
        for(int x : arr) {
            if(x < min) {
                min = x;
            }
        }
        return min;
    }
}
