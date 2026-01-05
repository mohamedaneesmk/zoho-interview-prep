public class TicTacToeWinner {
    public static void main(String[] args) {
        int[][] moves = {{0,0},{2,0},{1,1},{2,1},{2,2}};
        System.out.println(tictactoe(moves)); // Output: "A"
    }

    public static String tictactoe(int[][] moves) {
        int[] rows = new int[3];
        int[] cols = new int[3];
        int diag = 0, antiDiag = 0;

        // A = +1, B = -1
        int player = 1;
 
        for (int[] move : moves) {
            int row = move[0], col = move[1];

            rows[row] += player;
            cols[col] += player;

            if (row == col) diag += player;
            if (row + col == 2) antiDiag += player;

            // Check if current player won
            if (Math.abs(rows[row]) == 3 || Math.abs(cols[col]) == 3 || 
                Math.abs(diag) == 3 || Math.abs(antiDiag) == 3) {
                return player == 1 ? "A" : "B";
            }

            player *= -1; // Switch turn
        }

        return moves.length == 9 ? "Draw" : "Pending";
    }
}
