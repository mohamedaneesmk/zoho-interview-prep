import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {
        char[][] board = new char[3][3];

        // Initialize the board with empty spaces
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col] = ' ';
            }
        }

        char player = 'X'; // Player A = X, Player B = O
        boolean gameOver = false;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Tic-Tac-Toe!");
        System.out.println("Player A = X, Player B = O");
        System.out.println();

        while (!gameOver) {
            printBoard(board);
            System.out.println("Player " + player + ", it's your turn.");

            System.out.print("Enter row (0, 1, or 2): ");
            int row = scanner.nextInt();
            System.out.print("Enter column (0, 1, or 2): ");
            int col = scanner.nextInt();

            // Validate move
            if (row < 0 || row > 2 || col < 0 || col > 2) {
                System.out.println("Invalid position! Try again.");
                continue;
            }

            if (board[row][col] == ' ') {
                board[row][col] = player;

                // Check winner
                if (haveWonTheGame(board, player)) {
                    printBoard(board);
                    System.out.println("🎉 Player " + player + " has won the game!");
                    gameOver = true;
                } 
                else if (isBoardFull(board)) {
                    printBoard(board);
                    System.out.println("It's a draw! No more moves left.");
                    gameOver = true;
                } 
                else {
                    // Switch player
                    player = (player == 'X') ? 'O' : 'X';
                }
            } 
            else {
                System.out.println("That spot is already taken. Try again.");
            }
        }

        scanner.close();
    }

    // ✅ Check for winner
    private static boolean haveWonTheGame(char[][] board, char player) {
        // Check rows
        for (int row = 0; row < 3; row++) {
            if (board[row][0] == player && board[row][1] == player && board[row][2] == player) {
                return true;
            }
        }

        // Check columns
        for (int col = 0; col < 3; col++) {
            if (board[0][col] == player && board[1][col] == player && board[2][col] == player) {
                return true;
            }
        }

        // Check diagonals
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }

        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }

        return false;
    }

    // ✅ Check if the board is full (for draw)
    private static boolean isBoardFull(char[][] board) {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (board[row][col] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    // ✅ Print the board neatly
    private static void printBoard(char[][] board) {
        System.out.println();
        System.out.println("-------------");
        for (int row = 0; row < 3; row++) {
            System.out.print("| ");
            for (int col = 0; col < 3; col++) {
                System.out.print(board[row][col] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
        System.out.println();
    }
}
