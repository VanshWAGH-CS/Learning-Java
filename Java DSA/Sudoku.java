public class Sudoku {

    public boolean isSafe(char[][] board, int row, int col, char num) {
        // row & col
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == num) return false;  // check column
            if (board[row][i] == num) return false;  // check row
        }

        // 3x3 grid
        int sr = (row / 3) * 3;
        int sc = (col / 3) * 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[sr + i][sc + j] == num) return false;
            }
        }
        return true;
    }

    public boolean helper(char[][] board, int row, int col) {
        if (row == 9) return true;  // solved

        int nrow = 0, ncol = 0;
        if (col != 8) {
            nrow = row;
            ncol = col + 1;
        } else {
            nrow = row + 1;
            ncol = 0;
        }

        if (board[row][col] != '.') {
            return helper(board, nrow, ncol);
        } else {
            for (char num = '1'; num <= '9'; num++) {
                if (isSafe(board, row, col, num)) {
                    board[row][col] = num;
                    if (helper(board, nrow, ncol)) {
                        return true;
                    }
                    board[row][col] = '.'; // backtrack
                }
            }
        }
        return false;
    }

    public void solveSudoku(char[][] board) {
        helper(board, 0, 0);
    }

    public static void main(String[] args) {
        char[][] board = {
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

        Sudoku solver = new Sudoku();
        solver.solveSudoku(board);

        // print solved sudoku
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
