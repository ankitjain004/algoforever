import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<String>> solution = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {

        List<String> temp = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) for (int j = 0; j < n; j++) board[i][j] = '.';
        solveNQueensUtil(board, 0, n);
        return solution;

    }


    public void solveNQueensUtil(char[][] board, int row, int n) {

        if (row == n) {
            List<String> ans = createString(board, n);
            solution.add(ans);
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col, n)) {
                board[row][col] = 'Q';
                solveNQueensUtil(board, row + 1, n);
                board[row][col] = '.';
            }
        }
    }

    private List<String> createString(char[][] board, int n) {
        List<String> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb = sb.append(board[i][j]);
            }
            ans.add(sb.toString());
        }
        return ans;
    }

    boolean isSafe(char[][] board, int row, int col, int n) {
        for (int i = 0; i < n; i++)
            if (board[i][col] == 'Q') return false;

        for (int i = 0; i < n; i++)
            if (board[row][i] == 'Q') return false;

        // up left row -> -1 col -1
        int tempRow = row;
        int tempCol = col;
        while (tempRow >= 0 && tempCol >= 0) {

            if (board[tempRow][tempCol] == 'Q') return false;
            tempRow = tempRow - 1;
            tempCol = tempCol - 1;
        }

        // up right row -> -1 col -1
        tempRow = row;
        tempCol = col;
        while (tempRow >= 0 && tempCol < n) {

            if (board[tempRow][tempCol] == 'Q') return false;
            tempRow = tempRow - 1;
            tempCol = tempCol + 1;
        }

        // down right row -> -1 col -1
        tempRow = row;
        tempCol = col;
        while (tempRow < n && tempCol < n) {

            if (board[tempRow][tempCol] == 'Q') return false;
            tempRow = tempRow + 1;
            tempCol = tempCol + 1;
        }

        // down left row -> -1 col -1
        tempRow = row;
        tempCol = col;
        while (tempRow < n && tempCol >= 0) {

            if (board[tempRow][tempCol] == 'Q') return false;
            tempRow = tempRow + 1;
            tempCol = tempCol - 1;
        }

        return true;
    }
}