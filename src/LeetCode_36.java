import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LeetCode_36 {
    public boolean isValidSudoku(char[][] board) {
        return validRows(board) && validCols(board) && validSections(board);
    }

    private boolean validSections(char[][] board) {
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                if (!validSection(board, i, i + 3, j, j + 3)) {
                    return false;
                }
            }

        }
        return true;
    }

    private boolean validSection(char[][] board, int r1, int r2, int c1, int c2) {
        System.out.printf("%d %d %d %d%n", r1, r2, c1, c2);
        boolean[] found = new boolean[10];
        for (int i = r1 ; i < r2; i++) {
            for (int j = c1; j < c2; j++) {
                int num = board[i][j] - '0';
                if(num < 0)
                    continue;
                if (found[num])
                    return false;
                found[num] = true;
            }
        }
        return true;
    }

    private boolean validCols(char[][] board) {
        boolean[] found = new boolean[10];
        for (int i = 0; i < 9; i++) {
            found = new boolean[10];
            for (int j = 0; j < 9; j++) {
                int num = board[j][i] - '0';
                if(num < 0)
                    continue;
                if (found[num])
                    return false;
                found[num] = true;
            }
        }
        return true;
    }

    private boolean validRows(char[][] board) {
        boolean[] found = new boolean[10];
        for (int i = 0; i < 9; i++) {
            found = new boolean[10];
            for (int j = 0; j < 9; j++) {
                int num = board[i][j] - '0';
                if(num < 0)
                    continue;
                if (found[num])
                    return false;
                found[num] = true;
            }
        }
        return true;
    }
    @Test
    public void test1() {
        char[][] sudoku = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        Assertions.assertTrue(isValidSudoku(sudoku));
    }    @Test
    public void test2() {
        char[][] sudoku = {
                {'.', '.', '.', '.', '5', '.', '.', '1', '.'},
                {'.', '4', '.', '3', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '3', '.', '.', '1'},
                {'8', '.', '.', '.', '.', '.', '.', '2', '.'},
                {'.', '.', '2', '.', '7', '.', '.', '.', '.'},
                {'.', '1', '5', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '2', '.', '.', '.'},
                {'.', '2', '.', '9', '.', '.', '.', '.', '.'},
                {'.', '.', '4', '.', '.', '.', '.', '.', '.'}
        };
        Assertions.assertFalse(isValidSudoku(sudoku));
    }
}
