import java.util.HashSet;

public class LeetCode_73 {
    public void setZeroes(int[][] matrix) {
        HashSet<Integer> col = new HashSet<>();
        HashSet<Integer> row = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    col.add(j);
                    row.add(i);
                }
            }
        }
        for (int x : row) {
            convertRow(x, matrix);
        }
        for (int x : col) {
            convertCol(x, matrix);
        }


    }

    private void convertCol(int j, int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][j] = 0;
        }
    }

    private void convertRow(int i, int[][] matrix) {
        for (int j = 0; j < matrix[0].length; j++) {
            matrix[i][j] = 0;
        }
    }
}
