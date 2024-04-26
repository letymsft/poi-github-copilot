//I need a public code of a sudoku game in java

public class Sudoku {
    public static boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            boolean[] m = new boolean[9];
            boolean[] n = new boolean[9];
            boolean[] o = new boolean[9];
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (m[(int) (board[i][j] - '1')]) {
                        return false;
                    }
                    m[(int) (board[i][j] - '1')] = true;
                }
                if (board[j][i] != '.') {
                    if (n[(int) (board[j][i] - '1')]) {
                        return false;
                    }
                    n[(int) (board[j][i] - '1')] = true;
                }
                int RowIndex = 3 * (i / 3);
                int ColIndex = 3 * (i % 3);
                if (board[RowIndex + j / 3][ColIndex + j % 3] != '.') {
                    if (o[(int) (board[RowIndex + j / 3][ColIndex + j % 3] - '1')]) {
                        return false;
                    }
                    o[(int) (board[RowIndex + j / 3][ColIndex + j % 3] - '1')] = true;
                }
            }
        }
        return true;
    }
}
