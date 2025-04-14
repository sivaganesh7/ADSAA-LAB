public class NQueens {

    static int N;

    // Function to print the board
    static void printSolution(char[][] board) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // Check if it's safe to place a queen at board[row][col]
    static boolean isSafe(char[][] board, int row, int col) {
        // Check column above
        for (int i = 0; i < row; i++)
            if (board[i][col] == 'Q')
                return false;

        // Check upper-left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 'Q')
                return false;

        // Check upper-right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < N; i--, j++)
            if (board[i][j] == 'Q')
                return false;

        return true;
    }

    // Recursive backtracking function
    static boolean solveNQueens(char[][] board, int row) {
        if (row == N) {
            printSolution(board); // Print one of the solutions
            return true; // Return true if at least one solution is found
        }

        boolean res = false;
        for (int col = 0; col < N; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 'Q'; // Place queen

                res = solveNQueens(board, row + 1) || res;

                board[row][col] = '.'; // Backtrack
            }
        }
        return res;
    }

    public static void main(String[] args) {
        N = 4; // You can change N to solve different sizes
        char[][] board = new char[N][N];

        // Initialize board with '.'
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                board[i][j] = '.';

        if (!solveNQueens(board, 0)) {
            System.out.println("No solution exists");
        }
    }
}
