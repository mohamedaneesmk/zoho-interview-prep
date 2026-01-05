import java.util.HashMap;
import java.util.Map;

public class KnightProbability {
    
    // All 8 possible knight moves
    private static final int[][] MOVES = {
        {-2, -1}, {-2, 1}, {-1, -2}, {-1, 2},
        {2, -1}, {2, 1}, {1, -2}, {1, 2}
    };
    
    // Memoization cache
    private Map<String, Double> memo;
    private int n;
    
    /**
     * Calculate the probability that a knight remains on an n x n chessboard
     * after making exactly k moves starting from (row, column).
     * Using HashMap for memoization.
     */
    public double knightProbability(int n, int k, int row, int column) {
        this.n = n;
        this.memo = new HashMap<>();
        return dp(row, column, k);
    }
    
    /**
     * Calculate probability of staying on board from position (r, c)
     * with movesLeft remaining moves.
     */
    private double dp(int r, int c, int movesLeft) {
        // Base case: no more moves needed
        if (movesLeft == 0) {
            return 1.0;
        }
        
        // Create key for memoization
        String key = r + "," + c + "," + movesLeft;
        
        // Check if already calculated
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        
        double probability = 0.0;
        
        // Try all 8 possible knight moves
        for (int[] move : MOVES) {
            int newR = r + move[0];
            int newC = c + move[1];
            
            // Check if new position is on the board
            if (newR >= 0 && newR < n && newC >= 0 && newC < n) {
                // Add probability: 1/8 for this move * probability from new position
                probability += dp(newR, newC, movesLeft - 1) / 8.0;
            }
        }
        
        memo.put(key, probability);
        return probability;
    }
    
    /**
     * Alternative implementation using 3D array for memoization.
     * Can be more efficient for smaller inputs.
     */
    public double knightProbabilityArray(int n, int k, int row, int column) {
        // dp[r][c][moves] = probability at position (r,c) with 'moves' remaining
        double[][][] dp = new double[n][n][k + 1];
        
        // Initialize: -1 means not calculated yet
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int m = 0; m <= k; m++) {
                    dp[i][j][m] = -1;
                }
            }
        }
        
        return dpArray(row, column, k, n, dp);
    }
    
    private double dpArray(int r, int c, int movesLeft, int n, double[][][] dp) {
        // Base case: no more moves needed
        if (movesLeft == 0) {
            return 1.0;
        }
        
        // Check if already calculated
        if (dp[r][c][movesLeft] != -1) {
            return dp[r][c][movesLeft];
        }
        
        double probability = 0.0;
        
        // Try all 8 possible knight moves
        for (int[] move : MOVES) {
            int newR = r + move[0];
            int newC = c + move[1];
            
            // Check if new position is on the board
            if (newR >= 0 && newR < n && newC >= 0 && newC < n) {
                probability += dpArray(newR, newC, movesLeft - 1, n, dp) / 8.0;
            }
        }
        
        dp[r][c][movesLeft] = probability;
        return probability;
    }
    
    // Main method for testing
    public static void main(String[] args) {
        KnightProbability solution = new KnightProbability();
        
        // Example 1
        System.out.println("Example 1 (HashMap approach):");
        int n = 3, k = 2, row = 0, column = 0;
        double result = solution.knightProbability(n, k, row, column);
        System.out.printf("Input: n = %d, k = %d, row = %d, column = %d%n", n, k, row, column);
        System.out.printf("Output: %.5f%n", result);
        System.out.println();
        
        // Example 2
        System.out.println("Example 2 (Array approach):");
        solution = new KnightProbability();
        n = 1;
        k = 0;
        row = 0;
        column = 0;
        result = solution.knightProbabilityArray(n, k, row, column);
        System.out.printf("Input: n = %d, k = %d, row = %d, column = %d%n", n, k, row, column);
        System.out.printf("Output: %.5f%n", result);
        System.out.println();
        
        // Additional test case
        System.out.println("Additional Example (HashMap approach):");
        solution = new KnightProbability();
        n = 8;
        k = 3;
        row = 4;
        column = 4;
        result = solution.knightProbability(n, k, row, column);
        System.out.printf("Input: n = %d, k = %d, row = %d, column = %d%n", n, k, row, column);
        System.out.printf("Output: %.5f%n", result);
        System.out.println("(Knight starting from center of 8x8 board with 3 moves)");
    }
}