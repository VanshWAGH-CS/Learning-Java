import java.util.ArrayList;
import java.util.List;

public class N_Queens {

    public boolean isSafe(char[][] board, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') return false;
            if (col - (row - i) >= 0 && board[i][col - (row - i)] == 'Q') return false;
            if (col + (row - i) < board.length && board[i][col + (row - i)] == 'Q') return false;
        }
        return true;
    }

    public void helper(char[][] board, List<List<String>> allBoards, int row) {
        if (row == board.length) {
            allBoards.add(construct(board));
            return;
        }

        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 'Q';
                helper(board, allBoards, row + 1);
                board[row][col] = '.'; // backtrack
            }
        }
    }

    public List<String> construct(char[][] board) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            res.add(new String(board[i]));
        }
        return res;
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];

        // Initialize board with '.'
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        helper(board, res, 0);
        return res;
    }

    public static void main(String args[]) {
        N_Queens nQueens = new N_Queens();
        List<List<String>> solutions = nQueens.solveNQueens(4);

        for (List<String> solution : solutions) {
            for (String row : solution) {
                System.out.println(row);
            }
            System.out.println();
        }
    }
}
