class SudokuSolver {
    public void solveSudoku(char[][] board) {
        solveSudokuUtil(board, 0, 0);

    }

    public boolean isSafe(char[][] board, int row, int col, char value) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == value)
                return false;
        }
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == value)
                return false;
        }
        int rowStart = (row / 3) * 3;
        int colStart = (col / 3) * 3;

        for (int i = rowStart; i <= rowStart + 2; i++) {
            for (int j = colStart; j <= colStart + 2; j++) {
                if (board[i][j] == value)
                    return false;
            }
        }
        return true;
    }

    public boolean isSolved(char[][] board) {
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++)
                if (board[i][j] == '.')
                    return false;
        return true;
    }

    public boolean solveSudokuUtil(char[][] board, int row, int col) {
        if (row == 8 && col == 9) return true;
        if (col == 9) {
            row = row + 1;
            col = 0;
        }

        int i = row;
        int j = col;
        if (board[i][j] != '.')
            return solveSudokuUtil(board, i, j + 1);

        for (int k = 1; k <= 9; k++) {
            if (isSafe(board, i, j, (char) ('0' + k))) {
                board[i][j] = (char) ('0' + k);
                if (solveSudokuUtil(board, i, j + 1)) {
                    return true;
                }
            }
            board[i][j] = '.';
        }

        return false;
    }
}